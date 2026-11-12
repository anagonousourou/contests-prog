package com.spa.leetcode.medium;

import java.util.*;

public class SuperUglyNumber {

    // https://leetcode.com/problems/super-ugly-number/submissions/2140535752/
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] dp = new int[n];
        int[] idx = new int[m];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                next = Math.min(next, (long) primes[j] * dp[idx[j]]);
            }

            dp[i] = (int) next;

            // Advance all primes that produced this same value,
            // to avoid duplicates.
            for (int j = 0; j < m; j++) {
                if ((long) primes[j] * dp[idx[j]] == next) {
                    idx[j]++;
                }
            }
        }

        return dp[n - 1];
    }


}
