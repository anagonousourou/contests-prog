package com.spa.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfMultipleArrays {

    //https://leetcode.com/problems/intersection-of-multiple-arrays/
    //Since each row has distinct elements, appearing in every row means that the element will have an occurence
    //equals to the number of rows
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                occurences.merge(nums[i][j], 1, Integer::sum);
            }
        }
        return occurences.entrySet().stream().filter(entry -> entry.getValue() == nums.length).map(Map.Entry::getKey).sorted().toList();
    }
}
