package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumWidthRamp {

    record Value(int position, int val) {

    }

    public int maxWidthRamp(int[] nums) {
       return 0;

    }

    // Time limit exceeded
    public int maxWidthRamp1(int[] nums) {
        List<Value> values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            values.add(new Value(i, nums[i]));
        }
        int currentMaxWidth = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + currentMaxWidth + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    currentMaxWidth = Math.max(currentMaxWidth, j - i);
                }
            }
        }
        return currentMaxWidth;
    }
}
