package com.comp301.a01sushi;

public class ShrimpPortion extends IngrPorImpl {
  public ShrimpPortion(double amount) {
    super(new Shrimp(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    } else {
      return new ShrimpPortion(other.getAmount() + this.getAmount());
    }
  }
}
