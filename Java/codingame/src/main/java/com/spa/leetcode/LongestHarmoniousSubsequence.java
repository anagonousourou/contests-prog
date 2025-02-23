package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestHarmoniousSubsequence {

    //https://leetcode.com/problems/longest-harmonious-subsequence/

    public int findLHS(int[] nums) {
        var occurences = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
            .stream().sorted(Comparator.comparing(Map.Entry::getKey)).toList();

        int maxLhs = 0;
        for (int i = 0; i < occurences.size() - 1; i++) {
          if(occurences.get(i).getKey() + 1 == occurences.get(i + 1).getKey()){
              maxLhs = (int) Math.max(maxLhs, occurences.get(i).getValue() + occurences.get(i + 1).getValue());
          }
        }
        return maxLhs;
    }
}
