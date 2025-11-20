package com.spa.leetcode.easy;

public class LargestTriangleArea {

    // https://leetcode.com/problems/largest-triangle-area/submissions/1639305715/
    public double largestTriangleArea(int[][] points) {
        double area = 0.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    area = Math.max(area, 0.5 * Math.abs((points[j][0] - points[i][0]) *
                        (points[k][1] - points[i][1]) - (points[k][0] - points[i][0]) *
                        (points[j][1] - points[i][1])));
                }
            }
        }
        return area;
    }
}
