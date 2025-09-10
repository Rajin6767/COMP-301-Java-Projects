package com.comp301.a02adventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;

public class NovicePositionTests {
  @Test
  public void constructorTest() {
//    for (int x = -10; x < 10; x += 2) {
//      for (int y = -10; y < 10; y += 2) {
//        Position pos = new PositionImpl(x, y);
//        assertNotNull(pos);
//      }
//    }
  }

  @Test
  public void fieldsTest() {
//    Field[] allFields = PositionImpl.class.getDeclaredFields();
//    for (Field field : allFields) {
//      if (!Modifier.isPrivate(field.getModifiers())) {
//        fail(field.getName() + " is not final");
//      }
//    }
  }

  @Test
  public void getXYTest() {
//    int x = -50;
//    int y = 50;
//    Position p = new PositionImpl(x, y);
//    assertEquals("getX() did not return the correct value", x, p.getX());
//    assertEquals("getY() did not return the correct value", y, p.getY());
  }

  @Test
  public void getNeighborNorthTest() {
//    Position p = new PositionImpl(0, 0);
//    Position pNorth = new PositionImpl(0, 0); // Value will be replaced immediately
//    try {
//      pNorth = p.getNeighbor(Direction.NORTH);
//    } catch (Throwable t) {
//      fail("Threw an exception when calling getNeighbor()");
//    }
//    assertEquals("Incorrect x coordinate of neighboring Position", 0, pNorth.getX());
//    assertEquals("Incorrect y coordinate of neighboring Position", 1, pNorth.getY());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getX());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getY());
  }

  @Test
  public void getNeighborSouthTest() {
//    Position p = new PositionImpl(0, 0);
//    Position pSouth = new PositionImpl(0, 0); // Value will be replaced immediately
//    try {
//      pSouth = p.getNeighbor(Direction.SOUTH);
//    } catch (Throwable t) {
//      fail("Threw an exception when calling getNeighbor()");
//    }
//    assertEquals("Incorrect x coordinate of neighboring Position", 0, pSouth.getX());
//    assertEquals("Incorrect y coordinate of neighboring Position", -1, pSouth.getY());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getX());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getY());
  }

  @Test
  public void getNeighborWestTest() {
//    Position p = new PositionImpl(0, 0);
//    Position pWest = new PositionImpl(0, 0); // Value will be replaced immediately
//    try {
//      pWest = p.getNeighbor(Direction.WEST);
//    } catch (Throwable t) {
//      fail("Threw an exception when calling getNeighbor()");
//    }
//    assertEquals("Incorrect x coordinate of neighboring Position", -1, pWest.getX());
//    assertEquals("Incorrect y coordinate of neighboring Position", 0, pWest.getY());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getX());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getY());
  }

  @Test
  public void getNeighborEastTest() {
//    Position p = new PositionImpl(0, 0);
//    Position pEast = new PositionImpl(0, 0); // Value will be replaced immediately
//    try {
//      pEast = p.getNeighbor(Direction.EAST);
//    } catch (Throwable t) {
//      fail("Threw an exception when calling getNeighbor()");
//    }
//    assertEquals("Incorrect x coordinate of neighboring Position", 1, pEast.getX());
//    assertEquals("Incorrect y coordinate of neighboring Position", 0, pEast.getY());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getX());
//    assertEquals("getNeighbor() mutated the Position instance", 0, p.getY());
  }
}
