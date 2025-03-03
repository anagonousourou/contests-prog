package com.spa.leetcode.medium;

import java.util.Arrays;

public class FindUniqueBinaryString {

    // https://leetcode.com/problems/find-unique-binary-string/submissions/1549613382/?envType=daily-question&envId=2025-02-20
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (Integer.parseInt(nums[i], 2) + 1 < Integer.parseInt(nums[i + 1], 2)) {
                return padZero(Integer.toBinaryString(Integer.parseInt(nums[i], 2) + 1), nums[0].length());
            }
        }
        String missing = Integer.toBinaryString(Integer.parseInt(nums[nums.length - 1], 2) + 1);
        if (missing.length() > nums[0].length()) {
            return padZero("", nums[0].length());
        } else {
            return padZero(missing, nums[0].length());
        }

    }

    static String padZero(String s, int n) {
        return "0".repeat(n - s.length()) + s;
    }
}
