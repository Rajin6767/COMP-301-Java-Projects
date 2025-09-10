package com.comp301.a01sushi;

public class CrabPortion extends IngrPorImpl {
  public CrabPortion(double amount) {
    super(new Crab(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    // Compare the ingredients using the ingredient object
    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    } else {
      return new CrabPortion(other.getAmount() + this.getAmount());
    }
  }
}
