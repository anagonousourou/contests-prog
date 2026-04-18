package com.spa.leetcode.easy;

public class KItemsWithSum {
    // TODO
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes + numZeros) {
            return Math.min(numOnes, k);
        } else {
            return numOnes - (numNegOnes - (k - numOnes - numZeros));
        }
    }
}
