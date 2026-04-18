package com.spa.leetcode.easy;

public class FruitsIntoBasketsII {

    // https://leetcode.com/problems/fruits-into-baskets-ii/submissions/1724374695/?envType=daily-question&envId=2025-08-05
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruit <= baskets[j]) {
                    baskets[j] = 0;
                    count++;
                    break;
                }
            }
        }
        return fruits.length - count;
    }
}
