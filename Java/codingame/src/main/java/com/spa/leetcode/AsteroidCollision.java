package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision {

    //TOBECONTINUED
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = asteroids.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.addLast(asteroids[i]);
            } else if (stack.getLast() * asteroids[i] > 0) {
                stack.addLast(asteroids[i]);
            } else if (stack.getLast() < 0 && asteroids[i] > 0) {
                stack.addLast(asteroids[i]);
            } else if (stack.getLast() > 0 && asteroids[i] < 0) {
                if (Math.abs(stack.getLast()) > Math.abs(asteroids[i])) {
                    //
                } else if (Math.abs(stack.getLast()) == Math.abs(asteroids[i])) {
                    stack.removeLast();
                } else {
                    stack.removeLast();
                    stack.addLast(asteroids[i]);
                }
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        var it = stack.descendingIterator();
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        return result;
    }
}
