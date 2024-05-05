package com.spa.leetcode;

public class ToeplitzMatrix {

    //https://leetcode.com/problems/toeplitz-matrix/submissions/1231439598/
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i + 1 < matrix.length && j + 1 < matrix[i].length && matrix[i][j] != matrix[i+1][j + 1]){
                    return false;
                }
            }
        }
        return true;
    }
}
