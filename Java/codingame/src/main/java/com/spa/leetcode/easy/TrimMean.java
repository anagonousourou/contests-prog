package com.spa.leetcode.easy;

import java.util.Arrays;

public class TrimMean {

    // https://leetcode.com/problems/mean-of-array-after-removing-some-elements/submissions/1197018023/
    public double trimMean(int[] arr) {
        int l = arr.length / 20;
        Arrays.sort(arr);
        return Arrays.stream(arr).skip(l).limit(arr.length -  2 * l).mapToDouble(i -> (double)i).average().getAsDouble();
    }
}
