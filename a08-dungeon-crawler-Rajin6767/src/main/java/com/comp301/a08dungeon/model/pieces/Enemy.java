package com.comp301.a08dungeon.model.pieces;

public class Enemy extends APiece implements MovablePiece {
  public Enemy() {
    super("Enemy", "enemy.png"); // or whatever img you want
  }

  @Override
  public CollisionResult collide(Piece other) {
    if (other == null) {
      return new CollisionResult(0, CollisionResult.Result.CONTINUE);
    } else if (other instanceof Treasure) {
      return new CollisionResult(0, CollisionResult.Result.CONTINUE);
    } else if (other instanceof Hero) {
      return new CollisionResult(0, CollisionResult.Result.GAME_OVER);
    } else if (other instanceof Wall || other instanceof Exit || other instanceof Enemy) {
      throw new IllegalArgumentException("Enemy cannot collide with wall, exit, or another enemy");
    } else {
      throw new IllegalArgumentException("Enemy collided with unknown piece");
    }
  }
}
