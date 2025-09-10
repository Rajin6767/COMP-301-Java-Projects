package com.comp301.a08dungeon.model.board;

import com.comp301.a08dungeon.model.pieces.CollisionResult;
import com.comp301.a08dungeon.model.pieces.Piece;

/** Defines the public operations on the game board. */
public interface Board {

  /** Initialize the board with given counts. */
  void init(int enemies, int treasures, int walls);

  /** Board width in cols. */
  int getWidth();

  /** Board height in rows. */
  int getHeight();

  /** Get the piece at that position (or null). */
  Piece get(Posn posn);

  /** Place a piece at newPos (removing it from its old Posn). */
  void set(Piece p, Posn newPos);

  /** Move the hero by a delta row/col, return the collision result. */
  CollisionResult moveHero(int drow, int dcol);

  /** Move all enemies one step (randomly), return GAME_OVER if hero dies. */
  CollisionResult moveEnemies();
}
