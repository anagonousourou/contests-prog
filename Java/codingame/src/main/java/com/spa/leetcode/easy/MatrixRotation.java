package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixRotation {

    // https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/submissions/1955684832/?envType=daily-question&envId=2026-03-22
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (!isEqual(mat, target)) {
                mat = rotate(mat);
            } else {
                return true;
            }
        }

        return false;
    }

    private int[][] rotate(int[][] mat) {
        int[][] rotatedCopy = new int[mat.length][mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                rotatedCopy[j][mat.length - 1 - i] = mat[i][j];
            }
        }
        return rotatedCopy;
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        return IntStream.range(0, mat.length)
            .allMatch(i -> Arrays.equals(mat[i], target[i]));
    }
}
