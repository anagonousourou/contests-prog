package com.spa.leetcode.easy;

public class MinMaxDifference {

    // https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/submissions/1430379474/
    public int minMaxDifference(int num) {
        long max = num;
        long min = num;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    long curr = Long.parseLong(String.valueOf(num).replace(i + "", j + ""));
                    max = Math.max(max, curr);
                    min = Math.min(min, curr);
                }
            }
        }
        return (int) (max - min);
    }
}
