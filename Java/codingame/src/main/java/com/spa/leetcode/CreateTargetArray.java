package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {


    //https://leetcode.com/problems/create-target-array-in-the-given-order/
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        return target.stream().mapToInt(Integer::intValue).toArray();
    }
}
