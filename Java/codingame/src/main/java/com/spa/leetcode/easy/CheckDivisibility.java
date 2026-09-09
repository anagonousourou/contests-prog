package com.spa.leetcode.easy;

public class CheckDivisibility {

    // https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/submissions/2117417884/?envType=daily-question&envId=2026-08-22
    public boolean checkDivisibility(int n) {
        int digitSum = String.valueOf(n).chars().map(Character::getNumericValue).sum();
        int digitProduct = String.valueOf(n).chars().map(Character::getNumericValue).reduce(1, (a , b) -> a * b);
        return n % (digitSum + digitProduct) == 0;
    }
}
