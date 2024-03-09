package com.spa.hackerrank;

public class SumVsXor {

    public static long sumXor(long n) {
        if(n == 0){
            return 1;
        }
        int bc = Long.bitCount(n);
        int nl = Long.toBinaryString(n).length();

        return (long) Math.pow(2, nl - bc);
    }
}
