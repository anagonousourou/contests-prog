package com.spa.leetcode;

import java.util.Arrays;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int[] points = new int[gain.length + 1];
        points[0] = 0;
        for (int i = 1; i < points.length; i++) {
            points[i] = points[i - 1] + gain[i];
        }
        return Arrays.stream(points).max().getAsInt();
    }
}
