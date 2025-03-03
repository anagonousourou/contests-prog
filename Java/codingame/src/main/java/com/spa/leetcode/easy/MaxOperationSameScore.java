package com.spa.leetcode.easy;

public class MaxOperationSameScore {


    // https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/submissions/1560216616/
    public int maxOperations(int[] nums) {
        int score = nums[0] + nums[1];

        int count = 1;
        for (int i = 2; i < nums.length - 1; i+=2) {
            if(score == nums[i] + nums[i + 1]){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
