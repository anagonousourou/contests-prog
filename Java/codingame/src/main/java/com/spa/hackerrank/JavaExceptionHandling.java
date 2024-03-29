package com.spa.hackerrank;

class MyCalculator {
    /*
     * Create the method long power(int, int) here.
     */
    long power(int a, int b) throws Exception {
        if (a == 0 && b == 0) {
            throw new Exception("n and p should not be zero.");
        }
        if (a < 0 || b < 0) {
            throw new Exception("n or p should not be negative.");
        }
        return (long) Math.pow(a, b);
    }

}

public class JavaExceptionHandling {
}
