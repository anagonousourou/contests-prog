package com.spa.leetcode;

import java.util.List;
import java.util.stream.IntStream;

public class SumIndicesWithKSetBits {

    //https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        return IntStream.range(0, nums.size())
            .filter(i -> Integer.bitCount(i) == k)
            .map(nums::get)
            .sum();
    }
}
