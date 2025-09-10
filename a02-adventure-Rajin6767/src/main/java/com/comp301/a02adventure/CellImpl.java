package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final Position position;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;
  private boolean hasChest;

  public CellImpl(int x, int y, String name, String description) {
    Position position = new PositionImpl(x, y);
    this.chest = null;
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    if (description == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    this.name = name;
    this.description = description;
    this.visited = false;
    this.position = position;
    this.hasChest = false;
  }

  public CellImpl(int x, int y) {
    this.chest = null;
    Position position = new PositionImpl(x, y);
    Inventory chest = new InventoryImpl();
    this.name = "";
    this.description = "";
    this.visited = false;
    this.position = position;
    this.hasChest = false;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    this.name = name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description can't be null");
    }
    this.description = description;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getChest() {
    return this.chest;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("Chest can't be null");
    }
    this.chest = chest;
    this.hasChest = true;
  }

  @Override
  public boolean getIsVisited() {
    return this.visited;
  }

  @Override
  public boolean hasChest() {
    return this.hasChest;
  }

  @Override
  public void visit() {
    this.visited = true;
  }
}
