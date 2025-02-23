package com.spa.leetcode.easy;

import java.util.Arrays;

public class TypeOfTriangle {

    // https://leetcode.com/problems/type-of-triangle/submissions/1550563177/
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }
}
