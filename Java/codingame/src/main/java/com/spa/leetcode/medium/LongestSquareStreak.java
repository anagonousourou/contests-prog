package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.BitSet;


public class LongestSquareStreak {

    // https://leetcode.com/problems/longest-square-streak-in-an-array/submissions/1486514118/
    public int longestSquareStreak(int[] nums) {
        BitSet set = new BitSet(100_002);

        for (int num : nums) {
            set.set(num);
        }

        int currentMax = 0;
        while (set.nextSetBit(0) != -1) {
            int currentLength = 1;
            int latestSquare = set.nextSetBit(0);
            if (latestSquare != -1) {
                set.clear(latestSquare);
                while (latestSquare * latestSquare > 0 && set.get(latestSquare * latestSquare)) {
                    set.clear(latestSquare * latestSquare);
                    currentLength++;
                    latestSquare = latestSquare * latestSquare;
                }
                currentMax = Math.max(currentMax, currentLength);
            }

        }

        return currentMax >= 2 ? currentMax : -1;
    }


    // Timeout
    public int longestSquareStreak2(int[] nums) {
        Arrays.sort(nums);

        int crossed = 0;
        int currentMax = 0;
        while (crossed != nums.length) {
            int currentLength = 0;
            int latestSquare = 0;
            for (int i = 0; i < nums.length; i++) {
                if (currentLength == 0) {
                    if (nums[i] != 0) {
                        currentLength = 1;
                        latestSquare = nums[i];
                        nums[i] = 0;
                        crossed++;
                    }
                } else {
                    if (latestSquare * latestSquare == nums[i]) {
                        currentLength++;
                        latestSquare = nums[i];
                        nums[i] = 0;
                        crossed++;
                    }
                }

                currentMax = Math.max(currentMax, currentLength);
            }
        }

        return currentMax >= 2 ? currentMax : -1;
    }


}
