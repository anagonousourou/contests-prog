package com.spa.leetcode;


public class FindThePivotInteger {

    //https://leetcode.com/problems/find-the-pivot-integer/
    public int pivotInteger(int n) {
        int xsquare = (n * n + n) / 2;
        double x = Math.sqrt(xsquare);
        if (x == Math.rint(x)) {
            return (int) x;
        }
        return -1;
    }
}
