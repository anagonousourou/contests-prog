package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {

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
