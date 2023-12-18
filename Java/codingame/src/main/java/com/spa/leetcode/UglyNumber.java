package com.spa.leetcode;

//https://leetcode.com/problems/ugly-number/
public class UglyNumber {
    public boolean isUgly(int input) {
        if (input <= 0) {
            return false;
        }

        long n = input;
        long i = 2;
        while (n != 1) {
            if (i > 5) {
                return false;
            }
            if (n % i == 0) {
                n = n / i;
            } else {
                i += 1;
            }

        }

        return true;
    }
}
