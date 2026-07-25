package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumAbsoluteDifference {
    private record Value(int i, int num){

    }
    // https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
    public int minAbsoluteDifference(List<Integer> nums, int x) {

        List<Value> values = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            values.add(new Value(i, nums.get(i)));
        }
        values.sort(Comparator.comparingInt(Value::num));
        return 0;
    }
}
