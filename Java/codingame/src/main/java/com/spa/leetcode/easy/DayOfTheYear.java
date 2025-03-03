package com.spa.leetcode.easy;

import java.time.LocalDate;

public class DayOfTheYear {

    // https://leetcode.com/problems/day-of-the-year/submissions/1549721042/
    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }
}
