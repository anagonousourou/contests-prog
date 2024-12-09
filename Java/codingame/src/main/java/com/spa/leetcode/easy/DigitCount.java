package com.spa.leetcode.easy;

public class DigitCount {

    // https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/submissions/1459223694/
    public boolean digitCount(String num) {
        int[] occurences = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            int digitValue = Character.getNumericValue(num.charAt(i));
            if(digitValue < occurences.length){
                occurences[digitValue] += 1;
            }

        }

        for (int i = 0; i < num.length(); i++) {
            if (Character.getNumericValue(num.charAt(i)) != occurences[i]) {
                return false;
            }
        }

        return true;
    }
}
