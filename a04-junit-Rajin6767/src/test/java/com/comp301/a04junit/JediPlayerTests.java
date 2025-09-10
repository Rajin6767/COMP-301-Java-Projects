package com.comp301.a04junit;

import com.comp301.a04junit.adventure.*;
import org.junit.Assert;
import org.junit.Test;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void testConstructor() {
    new PlayerImpl("abbi", 0, 1);
    try {
      new PlayerImpl(null, 0, 1);
      Assert.fail("Exception should have been thrown");
    } catch (IllegalArgumentException iae) {
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testGetName() {
    Player player1 = new PlayerImpl("rajin", 0, 1);
    Assert.assertEquals("rajin", player1.getName());
  }

  @Test
  public void testGetPosition() {
    Player player1 = new PlayerImpl("rajin", 0, 1);
    Assert.assertEquals(0, player1.getPosition().getX());
    Assert.assertEquals(1, player1.getPosition().getY());
  }

  @Test
  public void testGetInventory() {
    Player player1 = new PlayerImpl("rajin", 0, 1);
    Item item1 = new ItemImpl("phone");
    player1.getInventory().addItem(item1);
    Item item2 = new ItemImpl("wallet");
    player1.getInventory().addItem(item2);
    Assert.assertEquals(item1, player1.getInventory().getItems().get(0));
    Assert.assertEquals(item2, player1.getInventory().getItems().get(1));
  }

  @Test
  public void testMove() {
    Player player1 = new PlayerImpl("rajin", 0, 1);
    player1.move(Direction.NORTH);
    Assert.assertEquals(2, player1.getPosition().getY());
    player1.move(Direction.EAST);
    Assert.assertEquals(1, player1.getPosition().getX());
    player1.move(Direction.SOUTH);
    Assert.assertEquals(1, player1.getPosition().getY());
    player1.move(Direction.WEST);
    Assert.assertEquals(0, player1.getPosition().getX());
    // negatives

    Player player2 = new PlayerImpl("rajin2", -10, -11);
    player2.move(Direction.NORTH);
    Assert.assertEquals(-10, player2.getPosition().getY());
    player2.move(Direction.EAST);
    Assert.assertEquals(-9, player2.getPosition().getX());
    player2.move(Direction.SOUTH);
    Assert.assertEquals(-11, player2.getPosition().getY());
    player2.move(Direction.WEST);
    Assert.assertEquals(-10, player2.getPosition().getX());
  }
}
