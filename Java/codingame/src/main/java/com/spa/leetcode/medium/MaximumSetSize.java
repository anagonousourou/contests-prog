package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximumSetSize {

    // https://leetcode.com/problems/maximum-size-of-a-set-after-removals/
    public int maximumSetSize(int[] nums1, int[] nums2) {

        var occurences1 = Arrays.stream(nums1).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var occurences2 = Arrays.stream(nums2).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



        return 0;
    }
}
