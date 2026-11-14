package com.spa.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/single-number/submissions/1122539026/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
