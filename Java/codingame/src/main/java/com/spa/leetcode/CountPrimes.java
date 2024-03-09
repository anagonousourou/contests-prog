package com.spa.leetcode;

import java.util.BitSet;

public class CountPrimes {


    //https://leetcode.com/problems/count-primes/
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        BitSet sieve = new BitSet(n);
        sieve.set(2, n, true);
        for (long i = 2; i < Math.sqrt(n); i++) {
            if (sieve.get((int) i)) {
                for (long j = i * i; j < n; j = j + i) {
                    sieve.set((int) j, false);
                }
            }
        }
        return sieve.cardinality();
    }
}
