package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<List<Integer>> resultQueue = new PriorityQueue<>(k, Comparator.comparingInt(list -> list.getFirst() + list.get(1)));
        for (int value : nums1) {
            for (int i : nums2) {
                resultQueue.add(List.of(value, i));
            }
        }

        return result.subList(0, k);
    }
}
