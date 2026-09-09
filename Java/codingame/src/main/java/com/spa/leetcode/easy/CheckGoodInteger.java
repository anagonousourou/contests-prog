package com.spa.leetcode.easy;


public class CheckGoodInteger {


    // https://leetcode.com/problems/check-good-integer/submissions/2136016979/
    public boolean checkGoodInteger(int n) {
        int digitSum = String.valueOf(n).chars().map(Character::getNumericValue)
            .sum();
        int squareSum = String.valueOf(n).chars().map(Character::getNumericValue)
            .map(i -> i * i)
            .sum();

        return squareSum - digitSum >= 50;
    }


}
