package com.spa.leetcode;

public class HammingDistance {

    //https://leetcode.com/problems/hamming-distance/submissions/1174256050/
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
