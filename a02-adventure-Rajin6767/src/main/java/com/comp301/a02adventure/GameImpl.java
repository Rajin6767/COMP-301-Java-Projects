package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (player == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    if (map == null) {
      throw new IllegalArgumentException("Map can't be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return new ArrayList<>(player.getInventory().getItems());
  }

  @Override
  public boolean getIsWinner() {
    return this.player.getInventory().getNumItems() == this.map.getNumItems();
  }

  @Override
  public void printCellInfo() {

    System.out.println("Location: " + map.getCell(getPlayerPosition()).getName());
    System.out.println(map.getCell(getPlayerPosition()).getDescription());
    int x = this.getPlayerPosition().getX();
    int y = this.getPlayerPosition().getY();
    if (this.map.getCell(getPlayerPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (this.map.getCell(getPlayerPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.map.getCell(getPlayerPosition()).visit();
  }

  @Override
  public void openChest() {

    int x = this.getPlayerPosition().getX();
    int y = this.getPlayerPosition().getY();
    if (this.map.getCell(this.player.getPosition()).hasChest()) {
      if (this.map.getCell(this.player.getPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: "
                + this.map.getCell(x, y).getChest().getItems().toString());
        this.player.getInventory().transferFrom(map.getCell(x, y).getChest());
      }
    }
    if (!this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position position = player.getPosition().getNeighbor(direction);
    int x = position.getX();
    int y = position.getY();
    if (x < 0 || x >= map.getWidth() || y < 0 || y >= map.getHeight()) {
      return false;
    } else {
      Cell cell = map.getCell(position);
      return cell != null;
    }
  }

  @Override
  public void move(Direction direction) {
    if (!this.canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      this.player.move(direction);
      printCellInfo();
    }
  }
}
