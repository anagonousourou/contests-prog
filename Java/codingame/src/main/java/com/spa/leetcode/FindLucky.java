package com.spa.leetcode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLucky {

    // https://leetcode.com/problems/find-lucky-integer-in-an-array/
    public int findLucky(int[] arr) {
        var freqs = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Arrays.stream(arr).filter(i -> i == freqs.get(i).intValue()).max().orElse(-1);
    }
}
