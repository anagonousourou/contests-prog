package com.spa.leetcode;

import com.spa.commonfns.NumberHelpers;

import java.util.Arrays;

public class DifferenceOfSum {

    //https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
    public int differenceOfSum(int[] nums) {
        return Math.abs(Arrays.stream(nums).sum() - Arrays.stream(nums).map(n -> NumberHelpers.getDigits(n).sum()).sum());
    }


}
