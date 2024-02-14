package com.spa.leetcode;

import java.util.Arrays;

public class FindGreatestCommonDivisorOfArray {

    //https://leetcode.com/problems/find-greatest-common-divisor-of-array/
    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return gcd(min, max);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
