package com.spa.leetcode;

public class DifferenceOfSums {

    //https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
    public int differenceOfSums(int n, int m) {

        int num2 = 0;
        int i = 1;
        while (i * m <= n) {
            num2 += i * m;
            i++;
        }

        int num1 = ((n * (n + 1)) / 2) - num2;
        return num1 - num2;
    }
}
