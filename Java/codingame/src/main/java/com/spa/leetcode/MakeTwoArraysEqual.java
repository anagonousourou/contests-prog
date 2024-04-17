package com.spa.leetcode;

import java.util.Arrays;

public class MakeTwoArraysEqual {

    //https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/submissions/1200409476/
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
