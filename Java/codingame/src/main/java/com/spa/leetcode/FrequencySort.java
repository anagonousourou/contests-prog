package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {

    //https://leetcode.com/problems/sort-characters-by-frequency/
    public String frequencySort(String s) {
        var freqs = frequencies(s);

        return Arrays.stream(s.split("")).sorted(Comparator.<String>comparingLong(c -> -freqs.get(c)).thenComparing(String::compareTo)).map(String::valueOf).collect(Collectors.joining());
    }

    public static Map<String, Long> frequencies(String elements) {
        return Arrays.stream(elements.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    //https://leetcode.com/problems/sort-array-by-increasing-frequency/
    public int[] frequencySort(int[] nums) {
        var freqs = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Arrays.stream(nums).boxed().sorted((Integer a, Integer b) -> {
            int res = freqs.get(a).compareTo(freqs.get(b));
            return res == 0 ? -Integer.compare(a, b) : res;
        }).mapToInt(Integer::intValue).toArray();
    }
}
