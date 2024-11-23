package com.spa.leetcode.easy;

public class FindColumnWidth {

    // https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/submissions/1459090049/
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for (int[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                int width = row[j] == 0 ? 1 : (int) Math.log10(Math.abs(row[j])) + 1;
                width = row[j] < 0 ? width + 1 : width;
                ans[j] = Math.max(ans[j], width);
            }
        }

        return ans;
    }
}
