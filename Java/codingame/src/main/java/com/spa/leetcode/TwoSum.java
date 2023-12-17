package com.spa.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var numsList = Arrays.stream(nums).boxed().toList();
        var remsList = numsList.stream().map(n -> target - n).toList();
        List<Integer> solutions = new ArrayList<>(2);
        for (int i = 0; i < numsList.size(); i++) {
            if(numsList.contains(remsList.get(i)) && hasMatch(numsList, i + 1, remsList.get(i))) {
                solutions.add(i);
                solutions.add(getMatchIndex(numsList, i + 1, remsList.get(i)));
                break;
            }
        }
        return solutions.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean hasMatch(List<Integer> integers, int start, int needle){
        return integers.subList(start, integers.size()).stream().anyMatch(n -> n == needle);
    }

    int getMatchIndex(List<Integer> integers, int start, int needle){
        for (int i = start; i < integers.size(); i++) {
            if(integers.get(i) == needle){
                return i;
            }
        }
        return -1;
    }
}
