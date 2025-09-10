package com.comp301.a01sushi;

public class Nigiri implements Sushi {

  public enum NigiriType {
    SHRIMP,
    CRAB,
    EEL,
    YELLOWTAIL,
    TUNA,
  }

  private IngredientPortion nigiri;
  private IngredientPortion riceIngredient;

  public Nigiri(NigiriType type) {
    if (type == NigiriType.CRAB) {
      nigiri = new CrabPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == NigiriType.EEL) {
      nigiri = new EelPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == NigiriType.SHRIMP) {
      nigiri = new ShrimpPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == NigiriType.TUNA) {
      nigiri = new TunaPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
    if (type == NigiriType.YELLOWTAIL) {
      nigiri = new YellowtailPortion(0.75);
      riceIngredient = new RicePortion(0.5);
    }
  }

  @Override
  public String getName() {
    return (nigiri.getName() + " nigiri");
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {nigiri, riceIngredient};
  }

  @Override
  public int getCalories() {
    return (int) Math.round(nigiri.getCalories() + riceIngredient.getCalories());
  }

  @Override
  public double getCost() {
    return Math.round((nigiri.getCost() + riceIngredient.getCost()) * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    return nigiri.getIsRice();
  }

  @Override
  public boolean getHasShellfish() {
    return nigiri.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return nigiri.getIsVegetarian();
  }
}
