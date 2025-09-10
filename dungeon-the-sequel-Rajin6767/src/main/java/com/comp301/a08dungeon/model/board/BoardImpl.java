package com.comp301.a08dungeon.model.board;

import com.comp301.a08dungeon.model.pieces.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardImpl implements Board {
  private final Piece[][] board;
  private final int width;
  private final int height;
  private Hero hero;
  private final List<Enemy> enemies;
  private final Random rand;

  // Random board init
  public BoardImpl(int width, int height) {
    this.width = width;
    this.height = height;
    this.board = new Piece[height][width];
    this.enemies = new ArrayList<>();
    this.rand = new Random();
    init(/*default enemies*/ 2, /*default treasures*/ 2, /*default walls*/ 2);
  }

  // Custom-board ctor
  public BoardImpl(Piece[][] pieces) {
    this.height = pieces.length;
    this.width = pieces[0].length;
    this.board = new Piece[height][width];
    this.enemies = new ArrayList<>();
    this.rand = new Random();
    // copy pieces into board, track hero & enemies
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        Piece p = pieces[r][c];
        if (p != null) {
          p.setPosn(new Posn(r, c));
          board[r][c] = p;
          if (p instanceof Hero) {
            hero = (Hero) p;
          } else if (p instanceof Enemy) {
            enemies.add((Enemy) p);
          }
        }
      }
    }
  }

  @Override
  public void init(int enemiesCount, int treasuresCount, int wallsCount) {
    // clear
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        board[r][c] = null;
      }
    }
    enemies.clear();
    // place hero
    hero = new Hero();
    placePiece(hero);
    // place exit
    Exit exit = new Exit();
    placePiece(exit);
    // place treasures
    for (int i = 0; i < treasuresCount; i++) {
      Treasure t = new Treasure();
      placePiece(t);
    }
    // place enemies
    for (int i = 0; i < enemiesCount; i++) {
      Enemy e = new Enemy();
      placePiece(e);
      enemies.add(e);
    }
    // place walls
    for (int i = 0; i < wallsCount; i++) {
      Wall w = new Wall();
      placePiece(w);
    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Piece get(Posn posn) {
    return board[posn.getRow()][posn.getCol()];
  }

  @Override
  public void set(Piece p, Posn newPos) {
    // remove from old
    Posn old = p.getPosn();
    board[old.getRow()][old.getCol()] = null;
    // place new
    p.setPosn(newPos);
    board[newPos.getRow()][newPos.getCol()] = p;
    if (p instanceof Hero) {
      hero = (Hero) p;
    }
  }

  @Override
  public CollisionResult moveHero(int drow, int dcol) {
    Posn old = hero.getPosn();
    int nr = old.getRow() + drow;
    int nc = old.getCol() + dcol;
    // bounds or wall?
    if (nr < 0 || nr >= height || nc < 0 || nc >= width || board[nr][nc] instanceof Wall) {
      return new CollisionResult(0, CollisionResult.Result.CONTINUE);
    }
    // collide
    Piece other = board[nr][nc];
    CollisionResult result = hero.collide(other);
    // move hero
    board[old.getRow()][old.getCol()] = null;
    hero.setPosn(new Posn(nr, nc));
    board[nr][nc] = hero;
    return result;
  }

  @Override
  public CollisionResult moveEnemies() {
    for (Enemy e : new ArrayList<>(enemies)) {
      Posn pos = e.getPosn();
      // try random directions until valid
      int[] dr = {-1, 1, 0, 0};
      int[] dc = {0, 0, -1, 1};
      int idx = rand.nextInt(4);
      int nr = pos.getRow() + dr[idx];
      int nc = pos.getCol() + dc[idx];
      if (!isValidEnemyMove(nr, nc)) continue;
      Piece target = board[nr][nc];
      CollisionResult res = e.collide(target);
      // remove old spot
      board[pos.getRow()][pos.getCol()] = null;
      e.setPosn(new Posn(nr, nc));
      board[nr][nc] = e;
      if (res.getResults() == CollisionResult.Result.GAME_OVER) {
        return res;
      }
    }
    return new CollisionResult(0, CollisionResult.Result.CONTINUE);
  }

  // helpers

  private void placePiece(Piece p) {
    int r, c;
    do {
      r = rand.nextInt(height);
      c = rand.nextInt(width);
    } while (board[r][c] != null);
    p.setPosn(new Posn(r, c));
    board[r][c] = p;
  }

  private boolean isValidEnemyMove(int row, int col) {
    if (row < 0 || row >= height || col < 0 || col >= width) {
      return false;
    }
    Piece t = board[row][col];
    return t == null || t instanceof Hero || t instanceof Treasure;
  }
}
