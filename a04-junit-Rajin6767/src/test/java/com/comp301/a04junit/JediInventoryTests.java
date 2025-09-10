package com.comp301.a04junit;

import static org.junit.Assert.*;

import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;
import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {

  @Test
  public void testConstructor() {
    Inventory inventory = new InventoryImpl();
    assertNotNull("InventoryImpl constructor should create a valid object", inventory);
  }

  @Test
  public void testIsEmpty() {
    Inventory test1 = new InventoryImpl();
    assertTrue(test1.isEmpty());
    Item item1 = new ItemImpl("item1");
    test1.addItem(item1);
    assertFalse(test1.isEmpty());
  }

  @Test
  public void testGetNumItems() {
    Inventory test1 = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    test1.addItem(item1);
    Item item2 = new ItemImpl("item2");
    test1.addItem(item2);
    Item item3 = new ItemImpl("item3");
    test1.addItem(item3);
    assertEquals(3, test1.getNumItems());
  }

  @Test
  public void testGetItems() {
    Inventory test1 = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    test1.addItem(item1);
    Item item2 = new ItemImpl("item2");
    test1.addItem(item2);
    Item item3 = new ItemImpl("item3");
    test1.addItem(item3);

    List<Item> expected = new ArrayList<>();
    expected.add(item1);
    expected.add(item2);
    expected.add(item3);

    assertEquals("getItems() should return all items in the Inventory", expected, test1.getItems());
  }

  @Test
  public void testAddItem() {
    Inventory test1 = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    test1.addItem(item1);
    Item item2 = new ItemImpl("item2");
    test1.addItem(item2);
    assertEquals(2, test1.getNumItems());
  }

  @Test
  public void testRemoveItem() {
    Inventory test1 = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    test1.addItem(item1);
    Item item2 = new ItemImpl("item2");
    test1.addItem(item2);
    Item item3 = new ItemImpl("item3");
    test1.addItem(item3);

    test1.removeItem(item2);
    assertEquals(2, test1.getNumItems());
    assertFalse(
        "After removing item2, the inventory should not contain it",
        test1.getItems().contains(item2));
  }

  @Test
  public void testClear() {
    Inventory test1 = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    test1.addItem(item1);
    Item item2 = new ItemImpl("item2");
    test1.addItem(item2);
    Item item3 = new ItemImpl("item3");
    test1.addItem(item3);

    test1.clear();
    assertEquals("After calling clear(), inventory should be empty", 0, test1.getNumItems());
    assertTrue("getItems() should return an empty list after clear()", test1.getItems().isEmpty());
  }

  @Test
  public void testTransferFrom() {
    Inventory inventory1 = new InventoryImpl();
    Inventory inventory2 = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    Item item2 = new ItemImpl("item2");
    Item item3 = new ItemImpl("item3");

    inventory1.addItem(item1);
    inventory1.addItem(item2);
    inventory1.addItem(item3);

    inventory2.transferFrom(inventory1);

    assertEquals(
        "All items should have been transferred from inventory1 to inventory2",
        0,
        inventory1.getNumItems());
    assertEquals("inventory2 should now have 3 items", 3, inventory2.getNumItems());

    Inventory inventory3 = new InventoryImpl();
    inventory3.transferFrom(null);
  }
}
