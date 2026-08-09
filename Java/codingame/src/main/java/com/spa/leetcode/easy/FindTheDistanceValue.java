package com.spa.leetcode.easy;

import java.util.Arrays;

public class FindTheDistanceValue {

    // https://leetcode.com/problems/find-the-distance-value-between-two-arrays/submissions/2091185510/
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return (int) Arrays.stream(arr1)
            .filter(i ->  Arrays.stream(arr2).allMatch( j -> Math.abs(i - j) > d))
            .count();
    }

}
