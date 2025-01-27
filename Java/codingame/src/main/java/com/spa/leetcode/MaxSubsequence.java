package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxSubsequence {


    // https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/submissions/1415824097/
    private record Value(int val, int position) {

    }

    public int[] maxSubsequence(int[] nums, int k) {
        List<Value> elements = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            elements.add(new Value(nums[i], i));
        }
        return elements.stream()
            .sorted(Comparator.comparingInt(Value::val).reversed())
            .limit(k)
            .sorted(Comparator.comparingInt(Value::position))
            .mapToInt(Value::val)
            .toArray();
    }
}
