package com.comp301.a01sushi;

public class SeaweedPortion extends IngrPorImpl {
  public SeaweedPortion(double amount) {
    super(new Seaweed(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    } else {
      return new SeaweedPortion(other.getAmount() + this.getAmount());
    }
  }
}
