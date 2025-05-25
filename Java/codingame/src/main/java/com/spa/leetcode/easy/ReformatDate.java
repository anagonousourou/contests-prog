package com.spa.leetcode.easy;

import java.util.List;

public class ReformatDate {


    // https://leetcode.com/problems/reformat-date/submissions/1623793893/
    private static final List<String> months = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
    public String reformatDate(String date) {
        String[] parts = date.split("\\s");

        int day = Integer.parseInt(parts[0].substring(0, 1) + (Character.isDigit(parts[0].charAt(1)) ? parts[0].substring(1, 2) : ""));
        return "%s-%02d-%02d".formatted(parts[2],months.indexOf(parts[1]) + 1, day);
    }
}
