package com.spa.leetcode.easy;

public class NumberOfCommonFactors {

    //https://leetcode.com/problems/number-of-common-factors/submissions/1172975555/description/
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
