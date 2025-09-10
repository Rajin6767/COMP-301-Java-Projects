package com.comp301.a08dungeon.model;

import com.comp301.a08dungeon.model.board.Board;
import com.comp301.a08dungeon.model.board.BoardImpl;
import com.comp301.a08dungeon.model.board.Posn;
import com.comp301.a08dungeon.model.pieces.CollisionResult;
import com.comp301.a08dungeon.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private final Board board;
  private final List<Observer> observers = new ArrayList<>();
  private int curScore = 0, highScore = 0, level = 0;
  private STATUS status = STATUS.END_GAME;

  public ModelImpl(int width, int height) {
    this.board = new BoardImpl(width, height);
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
    board.init(level, 2, 2);
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
    if (status != STATUS.IN_PROGRESS) return;
    // Hero
    CollisionResult hr = board.moveHero(drow, dcol);
    curScore += hr.getPoints();
    if (hr.getResults() == CollisionResult.Result.GAME_OVER) {
      endGame();
      notifyObservers();
      return;
    }
    if (hr.getResults() == CollisionResult.Result.NEXT_LEVEL) {
      level++;
      board.init(level, 2, 2);
    }
    // Enemies
    CollisionResult er = board.moveEnemies();
    curScore += er.getPoints();
    if (er.getResults() == CollisionResult.Result.GAME_OVER) {
      endGame();
    }
    notifyObservers();
  }

  public void endGame() {
    status = STATUS.END_GAME;
    if (curScore > highScore) highScore = curScore;
  }

  @Override
  public void addObserver(Observer o) {
    observers.add(o);
  }

  private void notifyObservers() {
    for (Observer o : observers) o.update();
  }
}
