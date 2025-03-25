package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeArrays {


    // https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/submissions/1560211113/?envType=daily-question&envId=2025-03-02
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        return Stream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
            .collect(Collectors.toMap(elt -> elt[0], elt -> elt[1], Integer::sum))
            .entrySet().stream()
            .sorted(Comparator.comparingInt(Map.Entry::getKey))
            .map(elt -> new int[]{elt.getKey(), elt.getValue()})
            .toArray(int[][]::new);
    }
}
