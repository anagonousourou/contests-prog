package com.spa.leetcode;

import java.time.LocalDate;

public class DayOfTheWeek {
    // https://leetcode.com/problems/day-of-the-week/submissions/1269533560/
    public String dayOfTheWeek(int day, int month, int year) {
        var result = LocalDate.of(year, month, day).getDayOfWeek().toString();
        return result.charAt(0) + result.substring(1).toLowerCase();
    }
}
