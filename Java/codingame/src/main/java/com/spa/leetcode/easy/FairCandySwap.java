package com.spa.leetcode.easy;

import java.util.Arrays;

public class FairCandySwap {
    // https://leetcode.com/problems/fair-candy-swap/submissions/2072166611/
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = Arrays.stream(aliceSizes).sum();
        int bobTotal = Arrays.stream(bobSizes).sum();

        int total = aliceTotal + bobTotal;
        int bobExcess = bobTotal - (total / 2);

        for (int i = 0; i < bobSizes.length; i++) {
            for (int j = 0; j < aliceSizes.length; j++) {
                if(bobExcess == (bobSizes[i] - aliceSizes[j])){
                    return new int[]{aliceSizes[j], bobSizes[i]};
                }
            }
        }
        return new int[0];
    }
}
