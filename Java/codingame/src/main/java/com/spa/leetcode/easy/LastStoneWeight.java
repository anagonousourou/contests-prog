package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // https://leetcode.com/problems/last-stone-weight/submissions/2042075389/?envType=problem-list-v2&envId=dsa-sequence-valley-heap
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        Arrays.stream(stones).forEach(queue::add);

        while (queue.size() > 1){
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            if(stone1 > stone2){
                queue.offer(stone1 - stone2);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
