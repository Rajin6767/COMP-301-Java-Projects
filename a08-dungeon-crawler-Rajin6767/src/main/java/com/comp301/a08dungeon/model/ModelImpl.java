package com.comp301.a08dungeon.model;

import com.comp301.a08dungeon.model.board.Board;
import com.comp301.a08dungeon.model.board.BoardImpl;
import com.comp301.a08dungeon.model.board.Posn;
import com.comp301.a08dungeon.model.pieces.CollisionResult;
import com.comp301.a08dungeon.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private final List<Observer> observers;
  private final Board board;
  private int curScore;
  private int highScore;
  private int level;
  private STATUS status;

  public ModelImpl(int width, int height) {
    this.board = new BoardImpl(width, height);
    this.curScore = 0;
    this.highScore = 0;
    this.level = 0;
    this.status = STATUS.END_GAME;
    this.observers = new ArrayList<>();
  }

  // custom‐board ctor now starts “in progress” at level 1
  public ModelImpl(Board board) {
    this.board = board;
    this.curScore = 0;
    this.highScore = 0;
    this.level = 1;
    this.status = STATUS.IN_PROGRESS;
    this.observers = new ArrayList<>();
  }

  @Override
  public int getWidth() {
    return board.getWidth();
  }

  @Override
  public int getHeight() {
    return board.getHeight();
  }

  @Override
  public Piece get(Posn p) {
    return board.get(p);
  }

  @Override
  public int getCurScore() {
    return curScore;
  }

  @Override
  public int getHighScore() {
    return highScore;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public STATUS getStatus() {
    return status;
  }

  @Override
  public void startGame() {
    level = 1;
    curScore = 0;
    status = STATUS.IN_PROGRESS;
    board.init(level + 1, 2, 2);
    notifyObservers();
  }

  @Override
  public void endGame() {
    status = STATUS.END_GAME;
    if (curScore > highScore) {
      highScore = curScore;
    }
    notifyObservers();
  }

  @Override
  public void moveUp() {
    move(-1, 0);
  }

  @Override
  public void moveDown() {
    move(1, 0);
  }

  @Override
  public void moveLeft() {
    move(0, -1);
  }

  @Override
  public void moveRight() {
    move(0, 1);
  }

  private void move(int drow, int dcol) {
    if (status != STATUS.IN_PROGRESS) {
      return;
    }

    var result = board.moveHero(drow, dcol);
    curScore += result.getPoints();

    if (result.getResults() == CollisionResult.Result.NEXT_LEVEL) {
      level++;
      board.init(level + 1, 2, 2);
    } else if (result.getResults() == CollisionResult.Result.GAME_OVER) {
      endGame();
      return;
    }

    notifyObservers();
  }

  @Override
  public void addObserver(Observer o) {
    observers.add(o);
  }

  private void notifyObservers() {
    for (Observer o : observers) {
      o.update();
    }
  }
}
