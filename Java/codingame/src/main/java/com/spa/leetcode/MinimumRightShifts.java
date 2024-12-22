package com.spa.leetcode;

import java.util.List;

public class MinimumRightShifts {

    // https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/submissions/1419946501/
    public int minimumRightShifts(List<Integer> nums) {
        int minimumIndex = 0;
        boolean sorted = true;

        int currentMin = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < currentMin) {
                currentMin = nums.get(i);
                minimumIndex = i;
            }
        }

        int prev = currentMin;
        for (int i = (minimumIndex + 1) % nums.size(); i != minimumIndex; i = (i + 1) % nums.size()) {
            if (prev > nums.get(i)) {
                sorted = false;
                break;
            }
            prev = nums.get(i);
        }

        if (!sorted) {
            return -1;
        } else {
            return minimumIndex == 0 ? 0 : (nums.size() - minimumIndex);
        }

    }
}
