package com.spa.leetcode.medium;

import java.util.*;

public class FindArrowShots {


    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/2181368835/?envType=study-plan-v2&envId=leetcode-75
    record Interval(int start, int end) {
        boolean intersect(Interval other) {
            return other.start <= this.end && this.end <= other.end;
        }
    }

    public int findMinArrowShots(int[][] points) {
        var intervals = Arrays.stream(points)
            .map(ints -> new Interval(ints[0], ints[1]))
            .sorted(Comparator.comparing(Interval::end).thenComparing(Interval::start))
            .toList();

        List<Set<Interval>> intervalGroups = new ArrayList<>();

        int i = 0;
        while (i < intervals.size()) {
            Set<Interval> tmp = new HashSet<>();
            tmp.add(intervals.get(i));
            Interval current = intervals.get(i);
            boolean increment = true;
            for (int j = i + 1; j < intervals.size(); j++) {
                increment = false;
                if (current.intersect(intervals.get(j))) {
                    i = j + 1;
                    tmp.add(intervals.get(j));

                } else {
                    i = j;
                    break;
                }
            }
            if(increment){
                i++;
            }
            intervalGroups.add(tmp);
        }
        return intervalGroups.size();
    }
}

/**
 * [[Interval[start=6, end=8], Interval[start=7, end=12], Interval[start=3, end=8], Interval[start=3, end=9], Interval[start=2, end=8], Interval[start=2, end=9], Interval[start=0, end=9]],
 * [Interval[start=9, end=10], Interval[start=3, end=9], Interval[start=2, end=9], Interval[start=0, end=9]],
 * [Interval[start=0, end=6], Interval[start=2, end=8]]]
 */
