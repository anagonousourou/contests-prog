package com.spa.leetcode.easy;

public class MaxProducts {

    // https://leetcode.com/problems/maximum-product-of-two-digits/submissions/1793014415/
    public int maxProduct(int n) {
        int[] digits = String.valueOf(n).chars().map(Character::getNumericValue)
            .sorted().toArray();
        return digits[digits.length - 1] * digits[digits.length - 2];
    }
}
