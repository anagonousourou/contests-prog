package com.spa.leetcode;

import java.util.Arrays;

public class TrimMean {

    // https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
    public double trimMean(int[] arr) {
        int l = arr.length / 20;
        Arrays.sort(arr);
        return Arrays.stream(arr).skip(l).limit(arr.length -  2 * l).mapToDouble(i -> (double)i).average().getAsDouble();
    }
}
