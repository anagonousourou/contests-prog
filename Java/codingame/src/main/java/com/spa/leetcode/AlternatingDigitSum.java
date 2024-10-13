package com.spa.leetcode;

public class AlternatingDigitSum {

    // https://leetcode.com/problems/alternating-digit-sum/submissions/1419345873/
    public int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int sign = 1;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += sign * Character.getNumericValue(str.charAt(i));
            sign = -1 * sign;
        }
        return sum;
    }
}
