package com.spa.leetcode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;


//https://leetcode.com/problems/unique-number-of-occurrences
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .values().stream().distinct().count() == Arrays.stream(arr).distinct().count();
    }
}
