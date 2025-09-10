package com.comp301.a02adventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;

public class NoviceItemTests {
  @Test
  public void constructorTest() {
//    ItemImpl item1 = new ItemImpl("hello world");
//    assertNotNull(item1);
//    ItemImpl item2 = new ItemImpl("null");
//    assertNotNull(item2);
//    try {
//      new ItemImpl(null);
//    } catch (IllegalArgumentException e) {
//      return;
//    }
//    fail("Expected IllegalArgumentException when passing null for Item name in constructor");
  }

  @Test
  public void interfaceTest() {
//    ItemImpl item = new ItemImpl("Random #2654");
//    assertTrue(item instanceof Item);
  }

  @Test
  public void fieldsTest() {
//    Field[] allFields = ItemImpl.class.getDeclaredFields();
//    for (Field field : allFields) {
//      if (!Modifier.isPrivate(field.getModifiers())) {
//        fail(field.getName() + " is not private");
//      }
//    }
  }

  @Test
  public void getNameTest() {
//    ItemImpl item1 = new ItemImpl("item 3765");
//    ItemImpl item2 = new ItemImpl("item 13674");
//    ItemImpl item3 = new ItemImpl("item 75986");
//
//    assertEquals("getName() did not return the correct value", "item 3765", item1.getName());
//    assertEquals("getName() did not return the correct value", "item 13674", item2.getName());
//    assertEquals("getName() did not return the correct value", "item 75986", item3.getName());
  }

  @Test
  public void equalsItemsTest() {
//    Item item = new ItemImpl("item 43209");
//    Item sameItem = new ItemImpl("item 43209");
//    Item diffItem = new ItemImpl("Item 43209");
//
//    assertEquals(item, item);
//    assertEquals(item, sameItem);
//    assertNotEquals(item, diffItem);
//
//    Item item2 = new ItemImpl("item 1776");
//    assertNotEquals("apple", item2);
//
//    try {
//      item2.equals(null);
//    } catch (Throwable t) {
//      fail("Threw an exception when comparing an item to null");
//    }
//
//    assertNotEquals("Valid items should not be equal to null", null, item2);
  }

  @Test
  public void toStringTest() {
//    ItemImpl item1 = new ItemImpl("item 3765");
//    ItemImpl item2 = new ItemImpl("item 13674");
//    ItemImpl item3 = new ItemImpl("item 75986");
//
//    assertEquals("item 3765", item1.toString());
//    assertEquals("item 13674", item2.toString());
//    assertEquals("item 75986", item3.toString());
  }
}
