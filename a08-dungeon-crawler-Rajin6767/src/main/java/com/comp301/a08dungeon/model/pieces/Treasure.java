package com.comp301.a08dungeon.model.pieces;

public class Treasure extends APiece {
  public Treasure() {
    super("Treasure", "treasure.png"); // or whatever img path u want
  }

  public int getValue() {
    return 100;
  }
}
