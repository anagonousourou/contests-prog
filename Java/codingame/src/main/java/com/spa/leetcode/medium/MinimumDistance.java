package com.spa.leetcode.medium;

import java.util.*;

public class MinimumDistance {

    // https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/submissions/1975760866/?envType=daily-question&envId=2026-04-11
    public int minimumDistance(int[] nums) {
        Map<Integer, TreeSet<Integer>> elements = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            elements.computeIfAbsent(nums[i], _ -> new TreeSet<>()).add(i);
        }

        return elements.values().stream()
            .filter(tree -> tree.size() >= 3)
            .map(tree -> distance(tree.stream().toList()))
            .min(Integer::compareTo)
            .orElse(-1);
    }


    private int distance(List<Integer> elements){
        if( elements.size() < 3 ){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + 2 < elements.size(); i++) {
            min  = Math.min(Math.abs(elements.get(i) - elements.get(i + 1)) + Math.abs(elements.get(i + 1) - elements.get(i + 2))
                + Math.abs(elements.get(i) - elements.get(i + 2)), min);
        }
        return min;
    }
}
