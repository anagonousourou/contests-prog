package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    // https://leetcode.com/problems/minimum-absolute-difference/submissions/1549704464/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minimum = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                if (minimum > arr[i + 1] - arr[i]) {
                    result.clear();
                    result.add(List.of(arr[i], arr[i + 1]));
                } else if (minimum == arr[i + 1] - arr[i]) {
                    result.add(List.of(arr[i], arr[i + 1]));
                }
                minimum = Math.min(minimum, arr[i + 1] - arr[i]);
            }
        }
        return result;
    }
}
