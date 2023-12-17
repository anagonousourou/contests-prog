package com.spa.leetcode;

//https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
