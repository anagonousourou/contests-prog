package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    // https://leetcode.com/problems/set-matrix-zeroes/submissions/1640190293/?envType=daily-question&envId=2025-05-21
    public void setZeroes(int[][] matrix) {
        Set<Integer> lines = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    lines.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer line : lines) {
            Arrays.fill(matrix[line], 0);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
