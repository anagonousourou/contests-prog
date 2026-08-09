package com.spa.leetcode.easy;

import java.util.Arrays;

public class DeleteGreatestValue {

    // https://leetcode.com/problems/delete-greatest-value-in-each-row/submissions/2098699052/
    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int sum = 0;
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            sum += max;
        }
        return sum;
    }
}
