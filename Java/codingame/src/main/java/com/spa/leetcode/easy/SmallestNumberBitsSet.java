package com.spa.leetcode.easy;

public class SmallestNumberBitsSet {


    // https://leetcode.com/problems/smallest-number-with-all-set-bits/submissions/1560242744/
    public int smallestNumber(int n) {

        int i = n;
        while (Integer.toBinaryString(i).contains("0")){
            i++;
        }
        return i;
    }
}
