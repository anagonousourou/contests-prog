package com.spa.leetcode;

public class ModifyTheMatrix {

    //https://leetcode.com/problems/modify-the-matrix/submissions/1233373339/
    public int[][] modifiedMatrix(int[][] matrix) {

        int[] maxes = new int[matrix[0].length];
        for (int i = 0; i < maxes.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                maxes[i] = Math.max(maxes[i], matrix[j][i]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == -1){
                    matrix[i][j] = maxes[j];
                }
            }
        }
        return matrix;
    }
}
