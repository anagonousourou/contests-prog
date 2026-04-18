package com.spa.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class MinMirrorPairDistance {

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> indicesPair = new HashMap<>();
        Map<Integer, Integer> reverses = new HashMap<>();

        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums.length; i++) {
            reverses.computeIfAbsent(nums[i], key ->
                Integer.parseInt(new StringBuilder(String.valueOf(key)).reverse().toString()));
            if(numsSet.contains(reverses.get(nums[i]))){
                for (int j = i + 1; j < nums.length; j++) {
                    if(reverses.get(nums[i]) == nums[j]){
                        indicesPair.put(i, j);
                        if(j - i == 1){
                            return j-i;
                        }
                        break;
                    }
                }
            }

        }
        return indicesPair.entrySet().stream().mapToInt(entry -> entry.getValue() - entry.getKey()).min().orElse(-1);
    }
}
