package com.spa.leetcode;

import java.util.Arrays;

public class MinElement {

    // https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/submissions/1419930468/
    public int minElement(int[] nums) {
        return Arrays.stream(nums).map(i -> String.valueOf(i).chars().map(Character::getNumericValue).sum())
                .min().orElseThrow();
    }
}
