package com.spa.codewars;

import java.math.BigInteger;

public class TheMillionthFibonacciKata {

    public static BigInteger fib(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ONE) == 0) {
            return n;
        } else if (BigInteger.TWO.compareTo(n) <= 0) {
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;
            for (BigInteger i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
                BigInteger tmp = b;
                b = b.add(a);
                a = tmp;
            }
            return b;
        } else {
            BigInteger n2 = BigInteger.ONE;
            BigInteger n1 = BigInteger.ZERO;
            for (BigInteger i = BigInteger.valueOf(-1); i.compareTo(n) >= 0; i = i.subtract(BigInteger.ONE)) {
                BigInteger tmp = n1;
                n1 = n2.subtract(n1);
                n2 = tmp;
            }
            return n1;
        }
    }


}
