package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

    //https://leetcode.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
