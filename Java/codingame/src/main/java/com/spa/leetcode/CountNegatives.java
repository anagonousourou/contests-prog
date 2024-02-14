package com.spa.leetcode;

public class CountNegatives {

    //https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public int countNegatives(int[][] grid) {
        int nb = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    break;
                }
                nb++;
            }
        }
        return nb;
    }
}
