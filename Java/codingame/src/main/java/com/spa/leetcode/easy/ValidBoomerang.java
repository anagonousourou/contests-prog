package com.spa.leetcode.easy;

public class ValidBoomerang {

    // https://leetcode.com/problems/valid-boomerang/submissions/1559006579/
    public boolean isBoomerang(int[][] points) {

        int ux = points[1][0] - points[0][0];
        int uy = points[1][1] - points[0][1];

        int vx = points[2][0] - points[1][0];
        int vy = points[2][1] - points[1][1];


        return ux * vy != uy * vx;
    }
}
