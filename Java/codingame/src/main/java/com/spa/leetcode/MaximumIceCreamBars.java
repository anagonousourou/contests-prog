package com.spa.leetcode;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int nbIceCreams = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                nbIceCreams += 1;
                coins -= costs[i];
            } else {
                return nbIceCreams;
            }
        }
        return nbIceCreams;
    }
}
