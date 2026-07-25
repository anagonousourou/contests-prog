package com.spa.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
        int right = 3;
        int left = 0;

        Map<String, Integer> occs = new HashMap<>();

        occs.compute(s.substring(0, 1), (_, b) -> (b == null ? 0 : b) + 1);
        occs.compute(s.substring(1, 2), (_, b) -> (b == null ? 0 : b) + 1);
        occs.compute(s.substring(2, 3), (_, b) -> (b == null ? 0 : b) + 1);

        return 0;
    }
}
