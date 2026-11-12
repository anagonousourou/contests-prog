package com.spa.leetcode.easy;

import java.util.Arrays;

public class GetMaximumGenerated {

    // https://leetcode.com/problems/get-maximum-in-generated-array/submissions/2144876998/
    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }

        int[] elts = new int[n + 1];
        elts[0] = 0;
        elts[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                elts[i] = elts[i / 2];
            } else {
                elts[i] = elts[(i - 1) / 2] + elts[((i - 1) / 2) + 1];
            }
        }
        return Arrays.stream(elts).max().orElseThrow();
    }
}
