package com.spa.leetcode.medium;

import java.math.BigInteger;
import java.util.List;

public class CountGoodNumbers {


    private List<Integer> primeDigits = List.of(2, 3, 5, 7);
    private List<Integer> evenDigits = List.of(0, 2, 4, 6, 8);

    // https://leetcode.com/problems/count-good-numbers/submissions/1605502529/?envType=daily-question&envId=2025-04-13
    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        long nbPrimeDigits = n / 2;
        long nbEvenDigits = n / 2;
        if (n % 2 != 0) {
            nbEvenDigits = n / 2 + 1;
        }
        var mod = BigInteger.TEN.pow(9).add(BigInteger.valueOf(7));
        return ((BigInteger.valueOf(4).modPow(BigInteger.valueOf(nbPrimeDigits), mod))
            .multiply(BigInteger.valueOf(5).modPow(BigInteger.valueOf(nbEvenDigits), mod))).mod(mod).intValue();
        /*return (((BigInteger.valueOf(4).pow((int) nbPrimeDigits)).multiply(BigInteger.valueOf(5).pow((int) nbEvenDigits)))
            .mod(BigInteger.TEN.pow(9).add(BigInteger.valueOf(7)))).intValue();*/
    }
}
