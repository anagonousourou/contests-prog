package com.spa.leetcode;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class ThirdMaximumNumber {

    //https://leetcode.com/problems/third-maximum-number/
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if(count == 2 && nums[i + 1] != nums[i]){
                return nums[i];
            }
            if(i + 1 < nums.length && nums[i + 1] != nums[i]){
               count++;
            }
        }
        return nums[nums.length - 1];
    }

    //alternative solution
    public int thirdMax2(int[] nums) {
        SortedSet<Integer> maxs = new TreeSet<>();

        for (int num : nums) {
            if (maxs.size() < 3) {
                maxs.add(num);
            } else if (maxs.first() < num && !maxs.contains(num)) {
                maxs.add(num);
                maxs.remove(maxs.first());
            }
        }
        return maxs.size() == 3 ? maxs.first() : maxs.last();
    }
}
