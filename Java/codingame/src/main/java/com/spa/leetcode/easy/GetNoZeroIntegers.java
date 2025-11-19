package com.spa.leetcode.easy;

public class GetNoZeroIntegers {

    // https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/submissions/1763616701/
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                return new int[] { i, n - i };
            }
        }
        return new int[0];
    }
}
