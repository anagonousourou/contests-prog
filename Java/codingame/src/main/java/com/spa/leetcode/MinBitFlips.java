package com.spa.leetcode;

public class MinBitFlips {


    //https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
