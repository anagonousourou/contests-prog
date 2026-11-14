package com.spa.leetcode.easy;

//https://leetcode.com/problems/check-if-matrix-is-x-matrix/submissions/1168967822/
public class CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if ((i == j || i + j == grid.length - 1) && grid[i][j] == 0) {
                    return false;
                }
                if (i != j && i + j != grid.length - 1 && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
