package com.spa.leetcode;

public class NeareastValidPoint {

    //https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if ((points[i][0] == x || points[i][1] == y) && distance(x, y, points[i]) < minDistance) {
                minIndex = i;
                minDistance = distance(x, y, points[i]);
            }
        }
        return minIndex;
    }

    public int distance(int x, int y, int[] point) {
        return Math.abs(x - point[0]) + Math.abs(y - point[1]);
    }
}
