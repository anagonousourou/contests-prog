package com.spa.leetcode.easy;

public class CaptureForts {
    // TODO
    public int captureForts(int[] forts) {
        int[] prefix = new int[forts.length];

        prefix[0] = forts[0];
        for (int i = 1; i < forts.length; i++) {
            prefix[i] = prefix[i - 1] + forts[i];
        }

        int maxForts = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                for (int j = 0; j < forts.length; j++) {
                    if (forts[j] == -1 && prefix[Math.max(i, j)] - prefix[Math.min(i, j)] - forts[Math.max(i, j)] == 0) {
                        maxForts = Math.max(maxForts, Math.abs(j - i) - 1);
                    }
                }
            }
        }
        return maxForts;
    }
}
