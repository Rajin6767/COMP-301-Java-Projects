package com.comp301.a01sushi;

public class Main {
  public static void main(String[] args) {
    // Roll.java code is making me crash out - test here >:(
    IngredientPortion ingredientx = new SeaweedPortion(0.25);
    IngredientPortion ingredienty = new AvocadoPortion(0.5);
    IngredientPortion ingredientz = new RicePortion(0.25);
    IngredientPortion[] ingredients = new IngredientPortion[3];
    ingredients[0] = ingredientx;
    ingredients[1] = ingredienty;
    ingredients[2] = ingredientz;
    Roll x = new Roll("luh avocado seaweed roll", ingredients);
    System.out.println(x.getCalories() + " is the amount of calories in this roll");

    // YOO IT WORKED
    // assertion tests
    assert x.getCalories() == 72 : "Cals should be 72";
    assert x.getCost() == 1.8 : "Cost should be 1.8";
    assert x.getHasRice() == true : "Roll most def should have rice";
    assert x.getIsVegetarian() == true : "Ig its vegetarian";
    assert x.getHasShellfish() == false : "I dont really like seafood...";

    System.out.println("LADIES AND GENTLEMEN WE GOT A ROLL, IT WORKED");
  }
}
