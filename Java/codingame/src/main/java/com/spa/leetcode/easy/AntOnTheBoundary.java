package com.spa.leetcode.easy;

public class AntOnTheBoundary {

    // https://leetcode.com/problems/ant-on-the-boundary/submissions/1585786856/
    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int count = 0;
        for (int num : nums) {
            position += num;
            if (position == 0) {
                count++;
            }
        }
        return count;
    }
}
