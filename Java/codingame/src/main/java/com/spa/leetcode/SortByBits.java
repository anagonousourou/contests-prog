package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class SortByBits {

    //https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
            .sorted(Comparator.comparingInt(Integer::bitCount).thenComparingInt(a -> a))
            .mapToInt(Integer::intValue).toArray();
    }
}
