package com.spa.leetcode;

public class MinimumRecolors {

    // https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/submissions/1419340765/

    // use a sliding window of length k and check the minimum whiteCount of each window
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0;
        int whiteCount = 0;
        int minimumRecolor = k;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }

            if (blackCount + whiteCount > k) {
                if (blocks.charAt(i - k) == 'W') {
                    whiteCount--;
                }
                if (blocks.charAt(i - k) == 'B') {
                    blackCount--;
                }
            }

            if (blackCount + whiteCount == k) {
                minimumRecolor = Math.min(minimumRecolor, whiteCount);
            }

        }

        return minimumRecolor;
    }
}
