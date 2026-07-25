package com.spa.leetcode.medium;

public class IntegerReplacement {

    public int integerReplacement(int n) {
        int nbSteps = 0;
        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : n - 1;
            nbSteps++;
        }
        return nbSteps;
    }
}
