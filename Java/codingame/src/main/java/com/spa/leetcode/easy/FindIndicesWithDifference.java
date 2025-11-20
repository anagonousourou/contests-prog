package com.spa.leetcode.easy;

public class FindIndicesWithDifference {

    // https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/submissions/1624215588/
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) >= valueDifference){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
