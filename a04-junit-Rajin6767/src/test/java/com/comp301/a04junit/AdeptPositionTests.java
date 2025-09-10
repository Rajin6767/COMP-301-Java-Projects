package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;
import org.junit.Assert;
import org.junit.Test;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void testConstructor() {
    Position position1 = new PositionImpl(1, 2);
  }

  @Test
  public void testGetX() {
    Position position1 = new PositionImpl(-20, 11);
    position1.getX();
    assertEquals(-20, position1.getX());
    Position position2 = new PositionImpl(120, 30);
    position2.getX();
    assertEquals(120, position2.getX());
  }

  @Test
  public void testGetY() {
    Position position1 = new PositionImpl(-25, -13);
    position1.getY();
    assertEquals(-13, position1.getY());
    Position position2 = new PositionImpl(20, 30);
    position2.getY();
    assertEquals(30, position2.getY());
  }

  @Test
  public void testGetNeighbor() {
    Position position1 = new PositionImpl(1, 2);
    Assert.assertEquals(3, position1.getNeighbor(Direction.NORTH).getY());
    Assert.assertEquals(1, position1.getNeighbor(Direction.NORTH).getX());
    Assert.assertEquals(1, position1.getNeighbor(Direction.SOUTH).getY());
    Assert.assertEquals(1, position1.getNeighbor(Direction.SOUTH).getX());
    Assert.assertEquals(2, position1.getNeighbor(Direction.EAST).getY());
    Assert.assertEquals(2, position1.getNeighbor(Direction.EAST).getX());
    Assert.assertEquals(2, position1.getNeighbor(Direction.WEST).getY());
    Assert.assertEquals(0, position1.getNeighbor(Direction.WEST).getX());
    // negatives
    Position position2 = new PositionImpl(-10, -11);
    Assert.assertEquals(-10, position2.getNeighbor(Direction.NORTH).getY());
    Assert.assertEquals(-10, position2.getNeighbor(Direction.NORTH).getX());
    Assert.assertEquals(-12, position2.getNeighbor(Direction.SOUTH).getY());
    Assert.assertEquals(-10, position2.getNeighbor(Direction.SOUTH).getX());
    Assert.assertEquals(-11, position2.getNeighbor(Direction.EAST).getY());
    Assert.assertEquals(-9, position2.getNeighbor(Direction.EAST).getX());
    Assert.assertEquals(-11, position2.getNeighbor(Direction.WEST).getY());
    Assert.assertEquals(-11, position2.getNeighbor(Direction.WEST).getX());
  }
}
