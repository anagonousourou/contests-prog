package com.spa.leetcode;

import java.util.Arrays;

public class MaximumValue {


    // https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/submissions/1415829053/
    public int maximumValue(String[] strs) {
        return Arrays.stream(strs)
            .mapToInt(str -> {
                try {
                    return Integer.parseInt(str);
                } catch (Exception e) {
                    return str.length();
                }
            }).max().orElseThrow();
    }

    // https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/submissions/1415830426/
    public int maximumValue2(String[] strs) {
        return Arrays.stream(strs)
            .mapToInt(str -> {
                if (str.chars().allMatch(Character::isDigit)) {
                    return Integer.parseInt(str);
                } else {
                    return str.length();
                }
            }).max().orElseThrow();
    }
}
