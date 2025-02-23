package com.spa.leetcode.easy;

import java.util.Arrays;

public class IsFascinating {

    // https://leetcode.com/problems/check-if-the-number-is-fascinating/submissions/1549501450/
    private static final char[] DIGITS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public boolean isFascinating(int n) {
        char[] s = (String.valueOf(n) + 2 * n + 3 * n) .toCharArray();
        Arrays.sort(s);
        return Arrays.equals(s, DIGITS);
    }
}
