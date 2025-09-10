package com.comp301.a02adventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class NoviceInventoryTests {
  @Test
  public void privateFieldsTest() {
//    Field[] allFields = InventoryImpl.class.getDeclaredFields();
//    assertNotEquals(allFields.length, 0);
//    for (Field field : allFields) {
//      if (!Modifier.isPrivate(field.getModifiers())) {
//        fail(field.getName() + " is not private");
//      }
//    }
  }

  @Test
  public void constructorTest() {
//    new InventoryImpl();
  }

  @Test
  public void initiallyEmptyTest() {
//    for (int i = 0; i < 3; i++) { // Do it 3 times just for fun
//      Inventory inv = new InventoryImpl();
//      assertInventoryContents(inv, new ArrayList<>());
//    }
  }

  @Test
  public void addItemsTest() {
//    Inventory inv1 = new InventoryImpl();
//    Inventory inv2 = new InventoryImpl();
//
//    Item item1 = new ItemImpl("item1");
//    Item item2 = new ItemImpl("item2");
//    Item item3 = new ItemImpl("item3");
//
//    assertInventoryContents(inv1, Collections.emptyList());
//    inv1.addItem(item1);
//    assertInventoryContents(inv1, Collections.singletonList(item1));
//    inv1.addItem(item2);
//    assertInventoryContents(inv1, Arrays.asList(item1, item2));
//    inv1.addItem(item3);
//    assertInventoryContents(inv1, Arrays.asList(item1, item2, item3));
//
//    assertInventoryContents(inv2, Collections.emptyList());
//    inv2.addItem(item1);
//    assertInventoryContents(inv2, Collections.singletonList(item1));
//    inv2.addItem(item2);
//    assertInventoryContents(inv2, Arrays.asList(item1, item2));
//    inv2.addItem(item3);
//    assertInventoryContents(inv2, Arrays.asList(item1, item2, item3));
  }

  @Test
  public void clearTest() {
//    Inventory inv = new InventoryImpl();
//    Item item1 = new ItemImpl("item1");
//    Item item2 = new ItemImpl("item2");
//    Item item3 = new ItemImpl("item3");
//
//    for (int i = 0; i < 3; i++) { // Do it 3 times just for fun
//      assertInventoryContents(inv, Collections.emptyList());
//      inv.clear();
//      assertInventoryContents(inv, Collections.emptyList());
//      inv.addItem(item1);
//      assertInventoryContents(inv, Collections.singletonList(item1));
//      inv.addItem(item2);
//      assertInventoryContents(inv, Arrays.asList(item1, item2));
//      inv.addItem(item3);
//      assertInventoryContents(inv, Arrays.asList(item1, item2, item3));
//      inv.clear();
//      assertInventoryContents(inv, Collections.emptyList());
//    }
  }

  @Test
  public void getItemsCloneTest() {
//    Inventory inv;
//    Item item1 = new ItemImpl("item1");
//    Item item2 = new ItemImpl("item2");
//    Item item3 = new ItemImpl("item3");
//
//    for (int i = 0; i < 3; i++) { // Do it 3 times just for fun
//      inv = new InventoryImpl();
//      assertInventoryContents(inv, Collections.emptyList());
//      inv.addItem(item1);
//      inv.addItem(item2);
//      inv.addItem(item3);
//      assertInventoryContents(inv, Arrays.asList(item1, item2, item3));
//      inv.getItems().clear();
//      assertInventoryContents(inv, Arrays.asList(item1, item2, item3));
//      inv.getItems().remove(item2);
//      assertInventoryContents(inv, Arrays.asList(item1, item2, item3));
//      assertNotSame(inv.getItems(), inv.getItems());
//    }
  }

  @Test
  public void addAndRemoveItemsTest() {
//    Inventory inv = new InventoryImpl();
//    Item item1 = new ItemImpl("item1");
//    Item item2 = new ItemImpl("item2");
//    Item item3 = new ItemImpl("item3");
//
//    for (int i = 0; i < 3; i++) { // Do it 3 times just for fun
//      assertInventoryContents(inv, Collections.emptyList());
//      inv.addItem(item1);
//      assertInventoryContents(inv, Collections.singletonList(item1));
//      inv.addItem(item2);
//      assertInventoryContents(inv, Arrays.asList(item1, item2));
//      inv.addItem(item3);
//      assertInventoryContents(inv, Arrays.asList(item1, item2, item3));
//      inv.removeItem(item1);
//      assertInventoryContents(inv, Arrays.asList(item2, item3));
//      inv.removeItem(item2);
//      assertInventoryContents(inv, Collections.singletonList(item3));
//      inv.removeItem(item3);
//      assertInventoryContents(inv, Collections.emptyList());
//    }
  }

  @Test
  public void transferTest() {
//    Inventory src = new InventoryImpl();
//    Inventory dst = new InventoryImpl();
//    Item item1 = new ItemImpl("item1");
//    Item item2 = new ItemImpl("item2");
//    Item item3 = new ItemImpl("item3");
//    Item item4 = new ItemImpl("item4");
//    assertInventoryContents(src, Collections.emptyList());
//    assertInventoryContents(dst, Collections.emptyList());
//    dst.transferFrom(src);
//    assertInventoryContents(src, Collections.emptyList());
//    assertInventoryContents(dst, Collections.emptyList());
//    src.addItem(item1);
//    dst.transferFrom(src);
//    assertInventoryContents(src, Collections.emptyList());
//    assertInventoryContents(dst, Collections.singletonList(item1));
//    src.addItem(item2);
//    src.addItem(item3);
//    src.addItem(item4);
//    dst.transferFrom(src);
//    assertInventoryContents(src, Collections.emptyList());
//    assertInventoryContents(dst, Arrays.asList(item1, item2, item3, item4));
//    src.transferFrom(dst);
//    assertInventoryContents(src, Arrays.asList(item1, item2, item3, item4));
//    assertInventoryContents(dst, Collections.emptyList());
  }

  private void assertInventoryContents(Inventory inv, List<Item> expected) {
    assertNotNull(inv);
    assertEquals(inv.getNumItems(), expected.size());
    assertEquals(inv.isEmpty(), expected.size() == 0);
    assertSameItemsAnyOrder(inv.getItems(), expected);
  }

  // Note, this doesn't exactly work but is close enough
  // See: https://stackoverflow.com/questions/22807328/assertequals-2-lists-ignore-order
  private void assertSameItemsAnyOrder(List<Item> a, List<Item> b) {
    assertNotNull(a);
    assertNotNull(b);
    assertEquals(a.size(), b.size());
    assertTrue(a.containsAll(b));
    assertTrue(b.containsAll(a));
  }
}
