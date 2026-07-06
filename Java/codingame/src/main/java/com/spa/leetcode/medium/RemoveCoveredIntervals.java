package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveCoveredIntervals {

    // https://leetcode.com/problems/remove-covered-intervals/submissions/2057932449/?envType=daily-question&envId=2026-07-06
    public int removeCoveredIntervals(int[][] intervals) {

        List<int[]> list =  new ArrayList<>(Arrays.asList(intervals));

        list.removeIf(interval -> Arrays.stream(intervals).anyMatch(candidate ->
            !Arrays.equals(interval, candidate) && candidate[0] <= interval[0] && candidate[1] >= interval[1]));

        return list.size();
    }
}
