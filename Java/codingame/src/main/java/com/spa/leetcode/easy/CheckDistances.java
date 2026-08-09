package com.spa.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckDistances {

    // https://leetcode.com/problems/check-distances-between-same-letters/submissions/2100112582/
    public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> previousIndices = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!previousIndices.containsKey(s.charAt(i) - 'a')) {
                previousIndices.put((s.charAt(i) - 'a'), i);
            } else if (i - previousIndices.get((s.charAt(i) - 'a')) - 1 != distance[s.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
