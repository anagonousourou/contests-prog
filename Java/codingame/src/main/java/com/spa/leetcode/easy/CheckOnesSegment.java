package com.spa.leetcode.easy;

import java.util.Arrays;

public class CheckOnesSegment {

    // https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/submissions/1476049412/
    public boolean checkOnesSegment(String s) {
        return Arrays.stream(s.split("0+"))
            .filter(segments -> segments.length() >= 1)
            .count() == 1;
    }
}
