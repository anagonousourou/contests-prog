package com.spa.leetcode;

public class SmallestEvenMultiple {

    //https://leetcode.com/problems/smallest-even-multiple/
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
