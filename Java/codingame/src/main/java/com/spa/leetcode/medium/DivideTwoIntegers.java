package com.spa.leetcode.medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long dividendCopy = Math.abs((long) dividend);
        long divisorCopy = Math.abs((long) divisor);
        int res = 0;
        while (dividendCopy >= divisorCopy) {
            res += 1;
            dividendCopy -= divisorCopy;
        }
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            return res;
        } else {
            return -res;
        }
    }
}
