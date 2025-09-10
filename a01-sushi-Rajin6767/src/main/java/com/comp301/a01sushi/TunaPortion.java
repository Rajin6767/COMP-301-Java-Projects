package com.comp301.a01sushi;

public class TunaPortion extends IngrPorImpl {
  public TunaPortion(double amount) {
    super(new Tuna(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    } else {
      return new TunaPortion(other.getAmount() + this.getAmount());
    }
  }
}
