package com.comp301.a01sushi;

public class Roll implements Sushi {
  private String name;
  private IngredientPortion[] ingredients;

  public Roll(String name, IngredientPortion[] ingredients) {
    this.name = name;

    this.ingredients = combineIngredients(ingredients);

    ensureSeaweed();
  }

  // Combine dupe ingredients
  private IngredientPortion[] combineIngredients(IngredientPortion[] ingredients) {
    IngredientPortion[] result = new IngredientPortion[ingredients.length];
    int index = 0;

    for (int i = 0; i < ingredients.length; i++) {
      boolean found = false;
      for (int j = 0; j < index; j++) {
        if (result[j].getIngredient().equals(ingredients[i].getIngredient())) {
          // Combine dupe portions of same ing
          result[j] = result[j].combine(ingredients[i]);
          found = true;
          break;
        }
      }
      if (!found) {
        result[index] = ingredients[i];
        index++;
      }
    }

    // Resize the array to match the actual number of ingredients
    IngredientPortion[] combined = new IngredientPortion[index];
    System.arraycopy(result, 0, combined, 0, index);

    return combined;
  }

  // im literally ripping my hair out, ive never had to write comments to remember stuff b4 dawg
  // Ensure at least more than no seaweed in the roll
  private void ensureSeaweed() {
    double seaweedAmount = 0;
    boolean hasSeaweed = false;

    for (IngredientPortion portion : ingredients) {
      if (portion.getIngredient() instanceof Seaweed) {
        hasSeaweed = true;
        seaweedAmount += portion.getAmount();
      }
    }

    if (!hasSeaweed || seaweedAmount < 0.1) {
      IngredientPortion seaweedPortion = new SeaweedPortion(0.1 - seaweedAmount);
      IngredientPortion[] newIngredients = new IngredientPortion[ingredients.length + 1];
      System.arraycopy(ingredients, 0, newIngredients, 0, ingredients.length);
      newIngredients[ingredients.length] = seaweedPortion;
      ingredients = newIngredients;
      // figure this out later but use System.arraycopy
      // syntax is like this System.arraycopy(Object src, int srcPos, Object dest, int destPos, int
      // length);
      // basically it copies a number of elements from source array starting from srcpos -> dest
      // from index desptPos
      // should throw an outofbounds exception if src or destpos is outta bounds -> check website
      // for instructions
      // and why is intellij flaming me for having informal text in my comments, hop off
    }
  }

  // Getters
  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return ingredients.clone();
  }

  @Override
  public int getCalories() {
    int totalCalories = 0;
    for (IngredientPortion ingredient : ingredients) {
      totalCalories += ingredient.getCalories();
    }
    return totalCalories;
  }

  @Override
  public double getCost() {
    double totalCost = 0;
    for (IngredientPortion ingredient : ingredients) {
      totalCost += ingredient.getCost();
    }
    return Math.round(totalCost * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    for (IngredientPortion ingredient : ingredients) {
      if (ingredient.getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion ingredient : ingredients) {
      if (ingredient.getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (IngredientPortion ingredient : ingredients) {
      if (!ingredient.getIsVegetarian()) {
        return false;
      }
    }
    return true;
  }
}
