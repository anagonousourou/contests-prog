package com.spa.leetcode.easy;

public class PowerOfFour {

    // https://leetcode.com/problems/power-of-four/submissions/1140274076/

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 4 == 0) {
            return isPowerOfFour(n / 4);
        }
        return false;
    }
}
