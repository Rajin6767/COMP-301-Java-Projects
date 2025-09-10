package com.comp301.a01sushi;

public class RicePortion extends IngrPorImpl {
  public RicePortion(double amount) {
    super(new Rice(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    } else {
      return new RicePortion(other.getAmount() + this.getAmount());
    }
  }
}
