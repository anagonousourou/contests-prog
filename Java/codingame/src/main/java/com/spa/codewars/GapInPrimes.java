package com.spa.codewars;

import com.spa.commonfns.NumberHelpers;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class GapInPrimes {
    public static long[] gap(int g, long m, long n) {
        long[] primes = LongStream.rangeClosed(m, n).filter(NumberHelpers::isPrime).toArray();
        for (int i = 0; i < primes.length - 1; i++) {
            if (primes[i + 1] - primes[i] == g) {
                return new long[]{primes[i], primes[i + 1]};
            }
        }
        return null;
    }

    public static IntStream stream() {
        return IntStream.iterate(2, i -> i + 1).filter(i ->
            BigInteger.valueOf(i).isProbablePrime(10)
        );
    }
}
