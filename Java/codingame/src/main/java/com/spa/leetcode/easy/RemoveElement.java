package com.spa.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/remove-element/submissions/1121182997/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        var uniqs = Arrays.stream(nums).filter(n -> n != val).toArray();
        System.arraycopy(uniqs, 0, nums, 0, uniqs.length);
        return uniqs.length;
    }
}
