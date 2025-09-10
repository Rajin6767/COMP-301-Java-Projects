package com.comp301.a01sushi;

public class YellowtailPortion extends IngrPorImpl {
  public YellowtailPortion(double amount) {
    super(new Yellowtail(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same.");
    } else {
      return new YellowtailPortion(other.getAmount() + this.getAmount());
    }
  }
}
