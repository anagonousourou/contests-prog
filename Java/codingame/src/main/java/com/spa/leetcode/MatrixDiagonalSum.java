package com.spa.leetcode;

public class MatrixDiagonalSum {

    //https://leetcode.com/problems/matrix-diagonal-sum/
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }

        for (int i = 0; i < mat.length; i++) {
            sum += i != mat.length - 1 - i ? mat[i][mat.length - 1 - i] : 0;
        }
        return sum;
    }
}
