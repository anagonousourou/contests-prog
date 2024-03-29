package com.spa.leetcode;

public class OddCells {


    //https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                matrix[index[0]][i] += 1;
            }

            for (int i = 0; i < m; i++) {
                matrix[i][index[1]] += 1;
            }
        }
        int nb = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {
                    nb++;
                }
            }
        }

        return nb;
    }
}
