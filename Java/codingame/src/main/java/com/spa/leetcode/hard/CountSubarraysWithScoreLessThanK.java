package com.spa.leetcode.hard;

public class CountSubarraysWithScoreLessThanK {

    // https://leetcode.com/problems/count-subarrays-with-score-less-than-k/submissions/1620411840/

    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        long sum = 0;
        int start = 0; // Start of the subarray

        for (int end = 0; end < n; end++) {
            sum += nums[end]; // Add current element to the sum

            // While the sum of the current subarray is too large, move the start forward
            while (sum * (end - start + 1) >= k && start <= end) {
                sum -= nums[start]; // Remove elements from the start of the subarray
                start++; // Move the start to the right
            }

            // The number of valid subarrays ending at 'end' is (end - start + 1)
            count += (end - start + 1);
        }

        return count;
    }
}
