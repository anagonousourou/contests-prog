package com.spa.leetcode.easy;

public class NumSpecial {

    // https://leetcode.com/problems/special-positions-in-a-binary-matrix/submissions/1623810450/
    public int numSpecial(int[][] mat) {

        int[] columns = new int[mat[0].length];
        int[] rows = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                columns[j]+= mat[i][j];
                rows[i] += mat[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(columns[j] == 1 && rows[i] == 1 && mat[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
