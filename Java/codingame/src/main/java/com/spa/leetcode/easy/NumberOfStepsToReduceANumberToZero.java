package com.spa.leetcode.easy;

public class NumberOfStepsToReduceANumberToZero {

    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/submissions/828777061/

     public int numberOfSteps(int num) {
        return num == 0 ? 0 : Integer.bitCount(num) + log2(num);
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int log2(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x (" + x + ") must be positive");
        }
        return 31 - Integer.numberOfLeadingZeros(x);
    }
}
