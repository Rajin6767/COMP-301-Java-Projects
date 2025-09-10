package com.comp301.a08dungeon.model.pieces;

public class Hero extends APiece implements MovablePiece {
  public Hero() {
    super("Hero", "hero.png"); // or whatever img you want
  }

  @Override
  public CollisionResult collide(Piece other) {
    if (other == null) {
      return new CollisionResult(0, CollisionResult.Result.CONTINUE);
    } else if (other instanceof Treasure t) {
      return new CollisionResult(t.getValue(), CollisionResult.Result.CONTINUE);
    } else if (other instanceof Enemy) {
      return new CollisionResult(0, CollisionResult.Result.GAME_OVER);
    } else if (other instanceof Exit) {
      return new CollisionResult(0, CollisionResult.Result.NEXT_LEVEL);
    } else if (other instanceof Wall) {
      throw new IllegalArgumentException("Hero cannot collide with wall");
    } else {
      throw new IllegalArgumentException("Hero collided with unknown piece");
    }
  }
}
