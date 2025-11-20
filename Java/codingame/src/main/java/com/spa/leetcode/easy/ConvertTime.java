package com.spa.leetcode.easy;

public class ConvertTime {


    // https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/submissions/1618474036/
    public int convertTime(String current, String correct) {
        int minutes = 0;
        int correctMinutesPart = Integer.parseInt(correct.substring(3));
        int currentMinutesPart = Integer.parseInt(current.substring(3));
        if (correctMinutesPart < currentMinutesPart) {
            minutes += (60 - currentMinutesPart) + correctMinutesPart;
            minutes += (Integer.parseInt(correct.substring(0, 2)) - 1 - Integer.parseInt(current.substring(0, 2))) * 60;
        } else {
            minutes += correctMinutesPart - currentMinutesPart;
            minutes += (Integer.parseInt(correct.substring(0, 2)) - Integer.parseInt(current.substring(0, 2))) * 60;
        }

        int count = 0;
        count += (minutes / 60);
        minutes = minutes % 60;
        count += (minutes / 15);
        minutes = minutes % 15;

        count += (minutes / 5);
        minutes = minutes % 5;

        count += minutes;
        return count;
    }
}
