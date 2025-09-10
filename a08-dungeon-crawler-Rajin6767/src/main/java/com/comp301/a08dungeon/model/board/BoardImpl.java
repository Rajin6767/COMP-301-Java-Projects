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

  public BoardImpl(int width, int height) {
    this.width = width;
    this.height = height;
    this.board = new Piece[height][width];
    this.enemies = new ArrayList<>();
    this.rand = new Random();
  }

  public BoardImpl(Piece[][] pieces) {
    this.height = pieces.length;
    this.width = pieces[0].length;
    this.board = pieces;
    this.enemies = new ArrayList<>();
    this.rand = new Random();
    for (Piece[] row : board) {
      for (Piece piece : row) {
        if (piece instanceof Enemy) {
          enemies.add((Enemy) piece);
        } else if (piece instanceof Hero) {
          hero = (Hero) piece;
        }
      }
    }
  }

  @Override
  public void init(int enemiesCount, int treasuresCount, int wallsCount) {
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        board[r][c] = null;
      }
    }
    enemies.clear();
    hero = null;

    int total = enemiesCount + treasuresCount + wallsCount + 2;
    if (total > width * height) {
      throw new IllegalArgumentException("Too many pieces for board size");
    }

    placePiece(new Hero());
    placePiece(new Exit());

    for (int i = 0; i < treasuresCount; i++) {
      placePiece(new Treasure());
    }
    for (int i = 0; i < wallsCount; i++) {
      placePiece(new Wall());
    }
    for (int i = 0; i < enemiesCount; i++) {
      Enemy enemy = new Enemy();
      placePiece(enemy);
      enemies.add(enemy);
    }
  }

  private void placePiece(Piece p) {
    int r, c;
    do {
      r = rand.nextInt(height);
      c = rand.nextInt(width);
    } while (board[r][c] != null);

    p.setPosn(new Posn(r, c));
    board[r][c] = p;

    if (p instanceof Hero) {
      hero = (Hero) p;
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
    if (posn == null
        || posn.getRow() < 0
        || posn.getRow() >= height
        || posn.getCol() < 0
        || posn.getCol() >= width) {
      return null;
    }
    if (hero != null && hero.getPosn().equals(posn)) {
      return hero;
    }
    return board[posn.getRow()][posn.getCol()];
  }

  @Override
  public void set(Piece p, Posn newPos) {
    if (newPos.getRow() < 0
        || newPos.getRow() >= height
        || newPos.getCol() < 0
        || newPos.getCol() >= width) {
      throw new IllegalArgumentException("Position out of bounds");
    }
    board[newPos.getRow()][newPos.getCol()] = p;
    if (p != null) {
      p.setPosn(newPos);
    }
  }

  @Override
  public CollisionResult moveHero(int drow, int dcol) {
    if (hero == null) {
      return new CollisionResult(0, CollisionResult.Result.CONTINUE);
    }

    Posn oldPos = hero.getPosn();
    int newRow = oldPos.getRow() + drow;
    int newCol = oldPos.getCol() + dcol;

    if (!isLegalMove(newRow, newCol)) {
      return new CollisionResult(0, CollisionResult.Result.CONTINUE);
    }

    Piece target = board[newRow][newCol];
    CollisionResult result = hero.collide(target);

    // *** ALWAYS MOVE the hero ***
    board[oldPos.getRow()][oldPos.getCol()] = null;
    hero.setPosn(new Posn(newRow, newCol));
    board[newRow][newCol] = hero;

    // if it's an exit, bail out now (hero is already on the exit)
    if (result.getResults() == CollisionResult.Result.NEXT_LEVEL) {
      return result;
    }

    // otherwise, move enemies and check for game over
    boolean enemyKilledHero = false;
    for (Enemy enemy : new ArrayList<>(enemies)) {
      if (moveEnemy(enemy)) {
        enemyKilledHero = true;
      }
    }
    if (enemyKilledHero) {
      return new CollisionResult(result.getPoints(), CollisionResult.Result.GAME_OVER);
    }

    return result;
  }

  private boolean isLegalMove(int row, int col) {
    if (row < 0 || row >= height || col < 0 || col >= width) {
      return false;
    }
    Piece target = board[row][col];
    return target == null || !(target instanceof Wall);
  }

  private boolean moveEnemy(Enemy enemy) {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    for (int[] dir : directions) {
      int newRow = enemy.getPosn().getRow() + dir[0];
      int newCol = enemy.getPosn().getCol() + dir[1];
      if (isValidEnemyMove(newRow, newCol)) {
        Piece target = board[newRow][newCol];
        CollisionResult result = enemy.collide(target);

        board[enemy.getPosn().getRow()][enemy.getPosn().getCol()] = null;
        enemy.setPosn(new Posn(newRow, newCol));
        board[newRow][newCol] = enemy;

        return result.getResults() == CollisionResult.Result.GAME_OVER;
      }
    }
    return false;
  }

  private boolean isValidEnemyMove(int row, int col) {
    if (row < 0 || row >= height || col < 0 || col >= width) {
      return false;
    }
    Piece target = board[row][col];
    return target == null || target instanceof Hero || target instanceof Treasure;
  }
}
