package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LastVisistedIntegers {

    // https://leetcode.com/problems/last-visited-integers/submissions/1549515891/
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();

        int negCount = 0;
        for (int n : nums) {
            if (n > 0) {
                negCount = 0;
                seen.add(0, n);
            } else {
                negCount++;
                if (negCount <= seen.size()) {
                    ans.add(seen.get(negCount - 1));
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }
}
