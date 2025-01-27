package com.spa.leetcode;

public class ValidClockTimes {

    // https://leetcode.com/problems/number-of-valid-clock-times/submissions/1416891844/
    public int countTime(String time) {
        int counter = 0;
        for (int hours = 0; hours < 24; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (match(time.substring(0, 2), "%02d".formatted(hours)) && match(time.substring(3), "%02d".formatted(minutes))) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private static boolean match(String pattern, String value) {
        return (pattern.charAt(0) == '?' || pattern.charAt(0) == value.charAt(0)) &&
            (pattern.charAt(1) == '?' || pattern.charAt(1) == value.charAt(1));
    }
}
