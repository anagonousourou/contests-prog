package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversal {

    // https://leetcode.com/problems/zigzag-grid-traversal-with-skip/submissions/1584179903/
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        boolean skip = false;
        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!skip) {
                        result.add(grid[i][j]);
                    }
                    skip = !skip;
                }
            } else {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if (!skip) {
                        result.add(grid[i][j]);
                    }
                    skip = !skip;
                }
            }
        }
        return result;
    }
}
