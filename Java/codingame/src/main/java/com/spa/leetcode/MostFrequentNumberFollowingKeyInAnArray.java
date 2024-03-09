package com.spa.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberFollowingKeyInAnArray {

    //https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/submissions/1197929015/
    public int mostFrequent(int[] nums, int key) {

        Map<Integer, Integer> targets = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == key){
                targets.merge(nums[i], 1, Integer::sum);
            }
        }
        return targets.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();
    }
}
