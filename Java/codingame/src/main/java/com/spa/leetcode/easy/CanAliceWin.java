package com.spa.leetcode.easy;

public class CanAliceWin {

    // https://leetcode.com/problems/find-if-digit-game-can-be-won/submissions/1426220770/
    public boolean canAliceWin(int[] nums) {
        int singleDigit = 0;
        int doubleDigit = 0;

        for (var num : nums) {
            if (num < 10) {
                singleDigit += num;
            } else {
                doubleDigit += num;
            }
        }

        return singleDigit != doubleDigit;
    }
}
