package com.spa.leetcode.easy;

//https://leetcode.com/problems/number-of-1-bits/submissions/1121214500/
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
