package com.spa.leetcode;

import java.util.Comparator;

public class SecondLargestDigitInString {


    //https://leetcode.com/problems/second-largest-digit-in-a-string/
    public int secondHighest(String s) {
        int[] digits = s.chars().filter(Character::isDigit).distinct()
            .map(Character::getNumericValue)
            .sorted()
            .toArray();

        if(digits.length >= 2){
            return digits[digits.length - 2];
        }
        return -1;
    }
}
