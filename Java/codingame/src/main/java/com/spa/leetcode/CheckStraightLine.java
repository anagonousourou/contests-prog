package com.spa.leetcode;

public class CheckStraightLine {


    //https://leetcode.com/problems/check-if-it-is-a-straight-line/
    public boolean checkStraightLine(int[][] coordinates) {
        int ux = coordinates[1][0] - coordinates[0][0];
        int uy = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int vx = coordinates[i][0] - coordinates[0][0];
            int vy = coordinates[i][1] - coordinates[0][1];
            if (ux * vy - uy * vx != 0) {
                return false;
            }
        }
        return true;
    }

}
