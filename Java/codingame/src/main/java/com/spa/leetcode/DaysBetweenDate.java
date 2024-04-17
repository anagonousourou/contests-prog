package com.spa.leetcode;

import java.time.Duration;
import java.time.LocalDate;

public class DaysBetweenDate {
    //https://stackoverflow.com/questions/34440874/duration-ofdays-generates-unsupportedtemporaltypeexception#48732307
    //https://leetcode.com/problems/number-of-days-between-two-dates
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        return (int) Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();
    }
}
