package com.spa.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class CheckValid {

    // https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/submissions/1418440625/
    public boolean checkValid(int[][] matrix) {
        for (var row : matrix) {
            if (Arrays.stream(row).distinct().count() != matrix.length) {
                return false;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            var sets = new HashSet<>();
            for (int[] row : matrix) {
                sets.add(row[j]);
            }
            if (sets.size() != matrix.length) {
                return false;
            }
        }
        return true;
    }
}
