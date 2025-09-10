package com.comp301.a01sushi;

public class IngrPorImpl implements IngredientPortion {
  private double amount;
  private Ingredient ingredient;

  public IngrPorImpl(Ingredient ingredient, double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException();
    }
    this.amount = amount;
    this.ingredient = ingredient;
  }

  @Override
  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsShellfish() {
    return ingredient.getIsShellfish();
  }

  @Override
  public boolean getIsRice() {
    return ingredient.getIsRice();
  }

  @Override
  public double getCalories() {
    return ingredient.getCaloriesPerOunce() * amount;
  }

  @Override
  public double getCost() {
    return ingredient.getPricePerOunce() * amount;
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    }
    double amtsum = other.getAmount() + this.getAmount();
    return new IngrPorImpl(this.getIngredient(), amtsum);
  }
}
