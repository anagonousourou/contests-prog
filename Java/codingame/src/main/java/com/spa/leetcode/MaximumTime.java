package com.spa.leetcode;

public class MaximumTime {

    // https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/submissions/1419300605/

    public String maximumTime(String time) {
        String lastMatch = "";
        for (int hours = 0; hours < 24; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (match(time.substring(0, 2), "%02d".formatted(hours)) && match(time.substring(3), "%02d".formatted(minutes))) {
                    lastMatch = "%02d".formatted(hours) + ":" + "%02d".formatted(minutes);
                }
            }
        }
        return lastMatch;
    }

    private static boolean match(String pattern, String value) {
        return (pattern.charAt(0) == '?' || pattern.charAt(0) == value.charAt(0)) &&
                (pattern.charAt(1) == '?' || pattern.charAt(1) == value.charAt(1));
    }

}
