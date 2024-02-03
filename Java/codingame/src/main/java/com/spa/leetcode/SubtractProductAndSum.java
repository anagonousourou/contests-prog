package com.spa.leetcode;

import com.spa.commonfns.NumberHelpers;

public class SubtractProductAndSum {

    //https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    public int subtractProductAndSum(int n) {
        String number = String.valueOf(n);
        return NumberHelpers.getDigits(n)
            .reduce(1, (a, b) -> a * b) - number.chars().mapToObj(c -> (char) c).mapToInt(Character::getNumericValue).sum();
    }
}
