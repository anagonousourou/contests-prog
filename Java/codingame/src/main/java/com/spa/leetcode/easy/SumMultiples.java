package com.spa.leetcode.easy;

public class SumMultiples {

    // https://leetcode.com/problems/sum-multiples/submissions/1162908117/

    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
