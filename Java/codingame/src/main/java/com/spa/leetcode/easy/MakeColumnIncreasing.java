package com.spa.leetcode.easy;

public class MakeColumnIncreasing {


    // https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/submissions/1562381850/
    public int minimumOperations(int[][] grid) {

        int operations = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 1; i < grid.length; i++) {
                if(grid[i][j] <= grid[i-1][j]){
                    operations += (grid[i-1][j] + 1 - grid[i][j]);
                    grid[i][j] = grid[i-1][j] + 1;
                }
            }
        }
        return operations;

    }
}
