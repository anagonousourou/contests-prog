package com.spa.codewars;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.IntStream;

public class PrimeStreaming {

    static int[] primes = getPrimes(965_748_941);

    public static IntStream stream() {
        return Arrays.stream(primes);
    }

    public static int[] getPrimes(int maxPrime) {
        BitSet sieve = new BitSet(maxPrime);
        sieve.set(2, maxPrime, true);
        for (long i = 2; i < Math.sqrt(maxPrime); i++) {
            if (sieve.get((int) i)) {
                for (long j = i * i; j < maxPrime; j = j + i) {
                    sieve.set((int) j, false);
                }
            }
        }
        return sieve.stream().toArray();
    }
}
