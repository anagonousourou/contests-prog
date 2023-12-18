package com.spa.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
