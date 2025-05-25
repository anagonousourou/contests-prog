package com.spa.leetcode.easy;

public class CountPartitions {

    // https://leetcode.com/problems/count-partitions-with-even-sum-difference/submissions/1584196559/
    public int countPartitions(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < prefix.length - 1; i++) {
            if((prefix[prefix.length - 1] - 2 * prefix[i]) % 2 == 0){
                count++;
            }
        }
        return count;
    }

}
