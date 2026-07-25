package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigZagConversion {
    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }
        char[][] matrix = new char[numRows][1000];

        for (char[] row : matrix){
            Arrays.fill(row, ' ');
        }
        int i = 0;
        int j = 0;
        boolean down = true;
        boolean upDiagonal = false;

        for (int k = 0; k < s.length(); k++) {
            matrix[i][j] = s.charAt(k);
            if (down && i == numRows - 1) {
                upDiagonal = true;
                down = false;
                i--;
                j++;
            } else if (down) {
                i++;
            } else if (upDiagonal && i == 0) {
                upDiagonal = false;
                down = true;
                i++;
            } else if (upDiagonal) {
                i--;
                j++;
            }
        }

        return Arrays.stream(matrix).map(String::new).collect(Collectors.joining()).replaceAll(" ", "");
    }
}
