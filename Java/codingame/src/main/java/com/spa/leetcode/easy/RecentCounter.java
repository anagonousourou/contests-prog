package com.spa.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {

    // https://leetcode.com/problems/number-of-recent-calls/submissions/1123565763/

    private final Deque<Integer> calls = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        calls.addLast(t);
        while (calls.peekFirst() < t - 3000) {
            calls.pollFirst();
        }
        return calls.size();
    }
}
