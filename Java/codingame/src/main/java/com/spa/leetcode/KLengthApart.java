package com.spa.leetcode;

public class KLengthApart {

    // https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/submissions/1415096822/
    public boolean kLengthApart(int[] nums, int k) {
        int distanceSince = k + 1;
        for (int num : nums) {
            if (num == 1 && distanceSince < k) {
                return false;
            } else if (num == 1) {
                distanceSince = 0;
            } else if (num == 0) {
                distanceSince++;
            }
        }
        return true;
    }
}
