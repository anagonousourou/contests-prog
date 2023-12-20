package com.spa.leetcode;


//https://leetcode.com/problems/move-zeroes
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int frontier = 0;
        int seek = 0;

        while (frontier < nums.length && nums[frontier] != 0) {
            frontier++;
        }
        if (frontier == nums.length) {
            return;
        }

        while (seek < nums.length) {
            if (nums[seek] == 0) {
                int localSeek = seek + 1;
                while (localSeek < nums.length && nums[localSeek] == 0) {
                    localSeek++;
                }
                if (localSeek < nums.length) {
                    nums[frontier] = nums[localSeek];
                    nums[localSeek] = 0;
                    frontier++;
                }
            }
            seek++;
        }
        while (frontier < nums.length) {
            nums[frontier] = 0;
            frontier++;
        }

    }
}
