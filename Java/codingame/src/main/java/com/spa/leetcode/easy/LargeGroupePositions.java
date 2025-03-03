package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupePositions {


    // https://leetcode.com/problems/positions-of-large-groups/submissions/1525442862/
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        int currentStart = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (i - currentStart >= 3) {
                    result.add(List.of(currentStart, i - 1));
                }

                currentStart = i;
            }
        }
        if (s.length() - currentStart >= 3) {
            result.add(List.of(currentStart, s.length() - 1));
        }
        return result;
    }
}
