package com.spa.leetcode.easy;


// https://leetcode.com/problems/design-neighbor-sum-service/submissions/1426237738/
public class NeighborSum {

    private final int[] diagSum;
    private final int[] adjSum;

    public NeighborSum(int[][] grid) {
        this.diagSum = new int[grid.length * grid.length];
        this.adjSum = new int[grid.length * grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    diagSum[grid[i][j]] += grid[i - 1][j - 1];
                }
                if (i + 1 < grid.length && j + 1 < grid.length) {
                    diagSum[grid[i][j]] += grid[i + 1][j + 1];
                }

                if (i - 1 >= 0 && j + 1 < grid.length) {
                    diagSum[grid[i][j]] += grid[i - 1][j + 1];
                }
                if (i + 1 < grid.length && j - 1 >= 0) {
                    diagSum[grid[i][j]] += grid[i + 1][j - 1];
                }


                if (i - 1 >= 0) {
                    adjSum[grid[i][j]] += grid[i - 1][j];
                }
                if (i + 1 < grid.length) {
                    adjSum[grid[i][j]] += grid[i + 1][j];
                }

                if (j + 1 < grid.length) {
                    adjSum[grid[i][j]] += grid[i][j + 1];
                }
                if (j - 1 >= 0) {
                    adjSum[grid[i][j]] += grid[i][j - 1];
                }


            }
        }
    }

    public int adjacentSum(int value) {
        return adjSum[value];
    }

    public int diagonalSum(int value) {
        return diagSum[value];
    }
}
