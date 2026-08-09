package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumPopulationYear {

    // https://leetcode.com/problems/maximum-population-year/submissions/2098746655/
    public int maximumPopulation(int[][] logs) {

        int[] count = new int[101];

        for (var log : logs) {
            for (int year = log[0]; year < log[1]; year++) {
                count[year - 1950] += 1;
            }
        }

        int max = Arrays.stream(count).max().orElseThrow();
        return IntStream.range(0, count.length).filter(i -> max == count[i]).findFirst().orElseThrow() + 1950;
    }
}
