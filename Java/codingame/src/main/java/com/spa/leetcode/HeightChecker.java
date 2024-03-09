package com.spa.leetcode;

import java.util.Arrays;

public class HeightChecker {

    //https://leetcode.com/problems/height-checker/description/
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int nb = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                nb++;
            }
        }
        return nb;
    }
}
