package com.spa.leetcode.hard;


import java.util.*;
import java.util.stream.IntStream;

public class LargestRectangleInHistogram {

    record Bar(int index, int height) {
    }

    public int largestRectangleArea(int[] heights) {

        var bars = IntStream.range(0, heights.length).mapToObj(i -> new Bar(i, heights[i])).toList();


        Map<Bar, Bar> previousSmallerElements = getPreviousSmallerElements(bars);
        Map<Bar, Bar> nextSmallerElements = getPreviousSmallerElements(bars.reversed());

        int maxArea = 0;

        for (Bar bar : bars) {
            Bar nse = Objects.requireNonNullElse(nextSmallerElements.get(bar), new Bar(bars.size(), bar.height()));
            Bar pse = Objects.requireNonNullElse(previousSmallerElements.get(bar), new Bar(-1, bar.height()));

            maxArea = Math.max(maxArea, (nse.index() - pse.index() - 1) * bar.height());
        }
        return maxArea;
    }

    private static Map<Bar, Bar> getPreviousSmallerElements(List<Bar> bars) {
        Map<Bar, Bar> previousSmallerElements = new HashMap<>(bars.size());
        Deque<Bar> increasingStack = new LinkedList<>();
        for (Bar bar : bars) {
            if (increasingStack.isEmpty()) {
                increasingStack.push(bar);
            } else if (increasingStack.peek().height() < bar.height()) {
                previousSmallerElements.put(bar, increasingStack.peek());
                increasingStack.push(bar);
            } else if (increasingStack.peek().height() > bar.height()) {
                while (!increasingStack.isEmpty() && increasingStack.peek().height() >= bar.height()) {
                    increasingStack.pop();
                }
                if (!increasingStack.isEmpty()) {
                    previousSmallerElements.put(bar, increasingStack.peek());
                }
                increasingStack.push(bar);
            } else if (increasingStack.peek().height() == bar.height()) {
                previousSmallerElements.put(bar, previousSmallerElements.get(increasingStack.peek()));
                increasingStack.push(bar);
            }
        }
        return previousSmallerElements;
    }
}
