package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ZeroFilledSubArray {

    // https://leetcode.com/problems/number-of-zero-filled-subarrays/submissions/1485546310/
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> zerosSubArrays = new ArrayList<>();

        int currentCount = 0;
        for (int num : nums) {
            if (num == 0) {
                currentCount++;
            } else {
                if (currentCount > 0) {
                    zerosSubArrays.add(currentCount);
                }
                currentCount = 0;
            }
        }
        if (currentCount > 0) {
            zerosSubArrays.add(currentCount);
        }

        int totalNbZeros = zerosSubArrays.stream().max(Integer::compareTo).orElse(0);


        long count = 0;
        for (int i = 1; i <= totalNbZeros; i++) {
            for (int subs : zerosSubArrays) {
                if (subs == i) {
                    count++;
                } else if (subs > i) {
                    count += 1 + subs - i;
                }
            }
        }


        return count;
    }
}
