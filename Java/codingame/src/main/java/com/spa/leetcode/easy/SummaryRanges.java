package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    // https://leetcode.com/problems/summary-ranges/submissions/1425249933/
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        List<String> ranges = new ArrayList<>();
        int currentFrom = nums[0];
        int currentTo = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                ranges.add(makeRange(currentFrom, currentTo));
                currentFrom = nums[i];
                currentTo = nums[i];
            } else {
                currentTo = nums[i];
            }
        }
        ranges.add(makeRange(currentFrom, currentTo));
        return ranges;
    }

    private static String makeRange(int from, int to) {
        if (from == to) {
            return String.valueOf(from);
        }
        return "%d->%d".formatted(from, to);
    }
}
