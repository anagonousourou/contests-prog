package com.spa.leetcode.easy;

public class MinBitFlips {


    //https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/1175112825/
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
