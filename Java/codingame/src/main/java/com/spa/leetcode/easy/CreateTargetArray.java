package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {


    //https://leetcode.com/problems/create-target-array-in-the-given-order/submissions/1173949716/
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        return target.stream().mapToInt(Integer::intValue).toArray();
    }
}
