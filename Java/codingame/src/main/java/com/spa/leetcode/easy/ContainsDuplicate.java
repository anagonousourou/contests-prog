package com.spa.leetcode.easy;

import java.util.Arrays;

public class ContainsDuplicate {

    // https://leetcode.com/problems/contains-duplicate/submissions/1121262293/

    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}
