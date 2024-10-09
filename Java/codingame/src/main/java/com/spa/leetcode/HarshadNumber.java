package com.spa.leetcode;

public class HarshadNumber {

    // https://leetcode.com/problems/harshad-number/submissions/1415643219/
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = String.valueOf(x).chars().map(Character::getNumericValue).sum();
        return x % sum == 0 ? sum : -1;
    }
}
