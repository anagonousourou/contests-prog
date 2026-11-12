package com.spa.leetcode.easy;

public class ArrangingCoins {
    //TODO
    public int arrangeCoins(int n) {
        int i = 0;
        while ((i * (i + 1)) / 2 < n) {
            i++;
        }
        return i;
    }
}
