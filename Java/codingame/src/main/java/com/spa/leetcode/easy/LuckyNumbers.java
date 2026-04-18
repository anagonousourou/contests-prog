package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {

    // https://leetcode.com/problems/lucky-numbers-in-a-matrix/submissions/1834621648/
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] maxs = new int[matrix[0].length];

        int[] mins = Arrays.stream(matrix)
            .mapToInt(row -> Arrays.stream(row).min().orElseThrow())
            .toArray();
        for (int j = 0; j < matrix[0].length; j++) {
            maxs[j] = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                maxs[j] = Math.max(maxs[j], matrix[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < mins.length; i++) {
            for (int j = 0; j < maxs.length; j++) {
                if (matrix[i][j] == mins[i] && matrix[i][j] == maxs[j]) {
                    result.add(maxs[j]);
                    break;
                }
            }
        }
        return result;
    }
}
