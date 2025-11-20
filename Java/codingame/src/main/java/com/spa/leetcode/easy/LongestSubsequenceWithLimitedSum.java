package com.spa.leetcode.easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    // https://leetcode.com/problems/longest-subsequence-with-limited-sum/submissions/1618205231/
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int position = Arrays.binarySearch(prefixSum, queries[i]);
            if (position < 0) {
                answer[i] = Math.abs(position + 1);
            } else {
                answer[i] = position + 1;
            }
        }
        return answer;
    }
}
