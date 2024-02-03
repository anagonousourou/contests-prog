package com.spa.leetcode;

import java.util.Arrays;

public class AreNumbersAscending {

    //https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
    public boolean areNumbersAscending(String s) {
        var numbers = Arrays.stream(s.split(" ")).filter(w -> {
            try {
                Integer.parseInt(w);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] >= numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
