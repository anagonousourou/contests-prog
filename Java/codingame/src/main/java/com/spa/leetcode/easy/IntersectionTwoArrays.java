package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionTwoArrays {


    // https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/1474426221/
    public int[] intersect(int[] nums1, int[] nums2) {
        var occurrences1 = Arrays.stream(nums1).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var occurrences2 = Arrays.stream(nums2).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> result = new ArrayList<>();

        for (var entry : occurrences1.entrySet()) {
            long nbCommon = Math.min(entry.getValue(), occurrences2.getOrDefault(entry.getKey(), 0L));

            for (int i = 0; i < nbCommon; i++) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
