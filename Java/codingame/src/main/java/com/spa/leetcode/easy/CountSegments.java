package com.spa.leetcode.easy;

import java.util.Arrays;

public class CountSegments {

    // https://leetcode.com/problems/number-of-segments-in-a-string/submissions/1639295500/
    public int countSegments(String s) {
        return (int) Arrays.stream(s.split("\\s+")).filter(p -> !p.isBlank()).count();
    }
}
