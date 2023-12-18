package com.spa.leetcode;

import java.util.*;

//https://leetcode.com/problems/design-a-food-rating-system
public class FoodRatings {

    record Food(String name, String cuisine, int rating) {
        public Food updateRating(int newRating) {
            return new Food(name, cuisine, newRating);
        }
    }

    private final Map<String, Food> foodsMap;
    private final Map<String, SortedSet<Food>> cuisinesRankings;

    private final Comparator<Food> foodComparator = Comparator.comparing(Food::rating).thenComparing(Comparator.comparing(Food::name).reversed());

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodsMap = new HashMap<>(foods.length);
        cuisinesRankings = new HashMap<>((int) Arrays.stream(cuisines).distinct().count());
        for (int i = 0; i < foods.length; i++) {
            var food = new Food(foods[i], cuisines[i], ratings[i]);
            foodsMap.put(foods[i], food);
            if (cuisinesRankings.containsKey(cuisines[i])) {
                cuisinesRankings.get(cuisines[i]).add(food);
            } else {
                cuisinesRankings.put(cuisines[i], new TreeSet<>(foodComparator));
                cuisinesRankings.get(cuisines[i]).add(food);
            }
        }
    }

    public void changeRating(String foodName, int newRating) {
        var oldFood = foodsMap.get(foodName);
        var newFood = oldFood.updateRating(newRating);
        foodsMap.put(foodName, newFood);
        cuisinesRankings.get(oldFood.cuisine).remove(oldFood);
        cuisinesRankings.get(oldFood.cuisine).add(newFood);
    }

    public String highestRated(String cuisine) {
        return cuisinesRankings.get(cuisine).last().name();
    }
}
