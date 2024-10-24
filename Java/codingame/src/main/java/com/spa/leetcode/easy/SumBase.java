package com.spa.leetcode.easy;

public class SumBase {

    // https://leetcode.com/problems/sum-of-digits-in-base-k/submissions/1430322358/
    public int sumBase(int n, int k) {
        int dividend = n;
        int res = 0;
        while (dividend >= k) {
            res += dividend % k;
            dividend = dividend / k;
        }
        res += dividend;
        return res;
    }
}
