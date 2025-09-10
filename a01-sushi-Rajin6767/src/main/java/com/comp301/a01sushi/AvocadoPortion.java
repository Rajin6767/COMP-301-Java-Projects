package com.comp301.a01sushi;

public class AvocadoPortion extends IngrPorImpl {
  public AvocadoPortion(double amount) {
    super(new Avocado(), amount);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    // Compare the ingredients using the ingredient object
    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("Ingredients ain't the same");
    } else {
      return new AvocadoPortion(other.getAmount() + this.getAmount());
    }
  }
}
