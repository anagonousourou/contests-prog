package com.spa.leetcode.easy;

public class FindThePivotInteger {

    //https://leetcode.com/problems/find-the-pivot-integer/submissions/1841032546/
    public int pivotInteger(int n) {
        int xsquare = (n * n + n) / 2;
        double x = Math.sqrt(xsquare);
        if (x == Math.rint(x)) {
            return (int) x;
        }
        return -1;
    }
}
