package com.spa.leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestSumAfterKNegations {


    // https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/submissions/1477013886/
    public int largestSumAfterKNegations(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (var n : nums) {
            queue.add(n);
        }

        for (int i = 0; i < k; i++) {
            queue.offer(-queue.poll());
        }

        return queue.stream().mapToInt(Integer::intValue).sum();
    }
}
