package com.comp301.a01sushi;

public class EelPortion extends IngrPorImpl {
  public EelPortion(double amount) {
    super(new Eel(), amount);
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
