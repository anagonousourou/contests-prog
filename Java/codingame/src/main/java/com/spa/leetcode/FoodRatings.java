package com.spa.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FoodRatings {

    record Food(String name, String cuisine, int rating){
        public Food updateRating(int newRating){
            return new Food(name, cuisine, newRating);
        }
    }

    private final Map<String, Food> foodsMap;

    private final Comparator<Food> foodComparator = Comparator.comparing(Food::rating).thenComparing(Comparator.comparing(Food::name).reversed());
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodsMap = new HashMap<>(foods.length);
        for (int i = 0; i < foods.length; i++) {
            var food = new Food(foods[i], cuisines[i], ratings[i]);
            foodsMap.put(foods[i], food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        foodsMap.put(foodName, foodsMap.get(foodName).updateRating(newRating));
    }

    public String highestRated(String cuisine) {
        return foodsMap.values().stream().filter(food -> cuisine.equals(food.cuisine)).max(foodComparator).get().name;
    }
}
