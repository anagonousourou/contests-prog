package com.spa.leetcode;

public class NumberOfCommonFactors {

    //https://leetcode.com/problems/number-of-common-factors/description/
    public int commonFactors(int a, int b) {
        int g = Math.max(a, b);
        int nb = 0;
        for (int i = 1; i <= g; i++) {
            if (a % i == 0 && b % i == 0) {
                nb++;
            }
        }
        return nb;
    }
}
