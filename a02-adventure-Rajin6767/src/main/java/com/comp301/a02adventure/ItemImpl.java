package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Item) {
      Item otherCasted = (Item) other;
      return this.getName().equals(otherCasted.getName());
    }
    return false;
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
