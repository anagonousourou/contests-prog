package com.spa.leetcode;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumOfUniqueElements {

    // https://leetcode.com/problems/sum-of-unique-elements/submissions/1173003025/
    public int sumOfUnique(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() == 1)
            .mapToInt(Map.Entry::getKey).sum();
    }
}
