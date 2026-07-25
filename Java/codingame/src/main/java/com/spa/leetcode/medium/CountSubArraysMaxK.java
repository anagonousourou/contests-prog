package com.spa.leetcode.medium;

public class CountSubArraysMaxK {

    public long countSubarrays(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + (nums[i - 1] == max ? 1 : 0);
        }
        long count = 0;

        for (int i = 0; i < prefix.length; i++) {
            for (int j = i; j < prefix.length; j++) {
                if (prefix[j] - prefix[i] >= k) {
                    count++;
                }
            }
        }
        return count;
    }
    /*long count = 0;
        long nbMaximum = 1;
        int left = 0;

        for (int right = 0; right < n; right++) {
            product *= nums[right];

            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }*/

}
