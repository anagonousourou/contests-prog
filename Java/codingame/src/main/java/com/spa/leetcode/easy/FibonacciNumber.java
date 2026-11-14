package com.spa.leetcode.easy;

public class FibonacciNumber {

    // https://leetcode.com/problems/fibonacci-number/submissions/834850219/

     public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n, 1, 1, 0);
    }

    public int fib(int n, int i, int a, int b) {
        if (i == n) {
            return a;
        } else {
            return fib(n, i + 1, a + b, a);
        }
    }
}
