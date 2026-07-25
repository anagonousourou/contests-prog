package com.spa.leetcode.medium;

public class CountMajoritySubarrays {

    // https://leetcode.com/problems/count-subarrays-with-majority-element-i/submissions/2047610429/?envType=daily-question&envId=2026-06-25
    public int countMajoritySubarrays(int[] nums, int target) {
        int[] targetOccs = new int[nums.length];
        targetOccs[0] = nums[0] == target ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            targetOccs[i] = targetOccs[i - 1] + (nums[i] == target ? 1 : 0);
        }

        int  count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int left = i == 0 ? 0 : targetOccs[i - 1];
                if( (j - i) < 2 * (targetOccs[j - 1] - left)){
                    count++;
                }
            }
        }
        return count;
    }
}
