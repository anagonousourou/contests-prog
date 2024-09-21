package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RelativeSortArray {

    //https://leetcode.com/problems/relative-sort-array/submissions/1204155903/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       Map<Integer, Integer> order = IntStream.range(0, arr2.length).boxed().collect(Collectors.toMap(i -> arr2[(int) i], Function.identity()));

        return Arrays.stream(arr1).boxed().sorted(Comparator.<Integer>comparingInt(i -> order.getOrDefault(i, arr2.length)).thenComparingInt(i -> i))
            .mapToInt(Integer::intValue).toArray();
    }
}
