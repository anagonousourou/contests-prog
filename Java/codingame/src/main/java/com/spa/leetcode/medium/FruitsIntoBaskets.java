package com.spa.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

    public int totalFruit(int[] fruits) {

        // https://leetcode.com/problems/fruit-into-baskets/submissions/1723450742/?envType=daily-question&envId=2025-08-04
        int maxFruits = 1;
        Map<Integer, Integer> baskets = new HashMap<>();
        baskets.put(fruits[0], 1);
        if(fruits.length > 1){
            baskets.compute(fruits[1], (k, v) -> v == null ? 1 :  v + 1);
        }

        int leftBorder = 0;
        for (int i = 2; i < fruits.length; i++) {
            if(baskets.size() < 2 || baskets.containsKey(fruits[i])){
                baskets.compute(fruits[i], (k, v) -> v == null ? 1 :  v + 1);
            }else{
                maxFruits = Math.max(baskets.values().stream().mapToInt(Integer::intValue).sum(), maxFruits);
                while (baskets.size() == 2){
                    if(baskets.get(fruits[leftBorder]) == 1){
                        baskets.remove(fruits[leftBorder]);
                    }else{
                        baskets.compute(fruits[leftBorder], (k, v) -> v == null ? 0 :  v - 1);
                    }
                    leftBorder++;
                }
                baskets.compute(fruits[i], (k, v) -> v == null ? 1 :  v + 1);
            }
        }
        return Math.max(baskets.values().stream().mapToInt(Integer::intValue).sum(), maxFruits);
    }
}
