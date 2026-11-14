package com.spa.leetcode.easy;

import java.util.Arrays;

public class NumberofEmployeesWhoMetTheTarget {

    //https://leetcode.com/problems/number-of-employees-who-met-the-target/submissions/1168651460/description/

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(h -> h >= target).count();
    }
}
