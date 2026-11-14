package com.spa.leetcode.easy;

public class PowerOfTwo {

    // https://leetcode.com/problems/power-of-two/submissions/1179646857/

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
