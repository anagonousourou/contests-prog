package com.spa.leetcode;

public class MinimumDistanceToTheTargetElement {

    //https://leetcode.com/problems/minimum-distance-to-the-target-element
    public int getMinDistance(int[] nums, int target, int start) {
        int currentDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target && Math.abs(i - start) < currentDistance){
                currentDistance = Math.abs(i - start);
            }
        }
        return currentDistance;
    }
}
