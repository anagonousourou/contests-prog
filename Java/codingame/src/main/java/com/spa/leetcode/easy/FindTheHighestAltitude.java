package com.spa.leetcode.easy;

import java.util.Arrays;

public class FindTheHighestAltitude {
    // https://leetcode.com/problems/find-the-highest-altitude/submissions/1123631354/

    public int largestAltitude(int[] gain) {
        int[] points = new int[gain.length + 1];
        points[0] = 0;
        for (int i = 1; i < points.length; i++) {
            points[i] = points[i - 1] + gain[i];
        }
        return Arrays.stream(points).max().getAsInt();
    }
}
