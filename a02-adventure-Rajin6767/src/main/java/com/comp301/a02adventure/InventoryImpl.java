package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final List<Item> itemsList;

  public InventoryImpl() {
    itemsList = new ArrayList<Item>();
  }

  public boolean isEmpty() {
    return itemsList.isEmpty();
  }

  public int getNumItems() {
    return this.itemsList.size();
  }

  public List<Item> getItems() {
    return new ArrayList<>(itemsList);
  }

  public void addItem(Item item) {
    this.itemsList.add(item);
  }

  public void removeItem(Item item) {
    this.itemsList.remove(item);
  }

  public void clear() {
    this.itemsList.clear();
  }

  public void transferFrom(Inventory other) {
    for (int i = 0; i < other.getNumItems(); i++) {
      this.itemsList.add(other.getItems().get(i));
    }
    other.clear();
  }
}
