package com.spa.leetcode;

public class MinimumTimeVisitingAllPoints {

    //https://leetcode.com/problems/minimum-time-visiting-all-points/
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int xvec = points[i + 1][0] - points[i][0];
            int yvec = points[i + 1][1] - points[i][1];
            if (Math.abs(xvec) == Math.abs(yvec)) {
                time += Math.abs(xvec);
            } else {
                time += Math.min(Math.abs(xvec), Math.abs(yvec));
                time += Math.max(Math.abs(xvec), Math.abs(yvec)) - Math.min(Math.abs(xvec), Math.abs(yvec));
            }
        }
        return time;
    }
}
