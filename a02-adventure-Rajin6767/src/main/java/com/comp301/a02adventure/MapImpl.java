package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int width;
  private final int height;
  private final int numItems;
  private final CellImpl[][] board;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0) {
      throw new IllegalArgumentException("width can't be negative");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("height can't be negative");
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.board = new CellImpl[width][height];
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Cell getCell(int x, int y) {

    if (x >= this.getWidth() || x < 0) {
      throw new IndexOutOfBoundsException("x can't be less than 0");
    }
    if (y >= this.getHeight() || y < 0) {
      throw new IndexOutOfBoundsException("y can't be less than 0");
    }
    return this.board[x][y];
  }

  @Override
  public Cell getCell(Position position) {

    if (position == null) {
      throw new IllegalArgumentException("position can't be null");
    }
    if (position.getX() >= this.getWidth() || position.getX() < 0) {
      throw new IndexOutOfBoundsException("X can't be less than 0");
    }
    if (position.getY() >= this.getHeight() || position.getY() < 0) {
      throw new IndexOutOfBoundsException("Y can't be less than 0");
    }
    return this.board[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    if (x >= this.getWidth() || x < 0) {
      throw new IndexOutOfBoundsException("x can't be less than 0");
    }
    if (y >= this.getHeight() || y < 0) {
      throw new IndexOutOfBoundsException("Y can't be less than 0");
    }
    board[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
