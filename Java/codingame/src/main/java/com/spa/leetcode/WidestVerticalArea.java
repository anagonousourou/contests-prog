package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;


//https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
public class WidestVerticalArea {


    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,Comparator.comparing(p ->  p[0]));
        int maxWidth = 0;
        for (int i = 0; i < points.length - 1; i++) {
            maxWidth = Math.max(maxWidth, points[i + 1][0] - points[i][0]);
        }
        return maxWidth;
    }
}
