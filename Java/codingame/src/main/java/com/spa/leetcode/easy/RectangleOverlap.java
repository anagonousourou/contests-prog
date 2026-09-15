package com.spa.leetcode.easy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class RectangleOverlap {


    record Colored(int i, int color) {

    }

    private static boolean isAlternating(List<Colored> points) {
        for (int i = 0; i < points.size(); i++) {
            int finalI = i;
            int finalI1 = i;
            if (points.subList(0, i).stream().anyMatch(colored -> colored.color() != points.get(finalI1).color() && colored.i() != points.get(finalI1).i()) &&
                points.subList(i + 1, points.size()).stream().anyMatch(colored -> colored.color() != points.get(finalI).color() && colored.i() != points.get(finalI1).i())) {
                return true;
            }
        }
        return false;
    }

    // https://leetcode.com/problems/rectangle-overlap/submissions/2141811747/?envType=daily-question&envId=2026-09-14
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        List<Colored> xOrder = Stream.of(new Colored(rec1[0], 1), new Colored(rec1[2], 1), new Colored(rec2[0], 2), new Colored(rec2[2], 2))
            .sorted(Comparator.comparing(Colored::i).thenComparing(Colored::color))
            .toList();
        List<Colored> yOrder = Stream.of(new Colored(rec1[1], 1), new Colored(rec1[3], 1), new Colored(rec2[1], 2), new Colored(rec2[3], 2))
            .sorted(Comparator.comparing(Colored::i).thenComparing(Colored::color))
            .toList();
        System.out.println(yOrder);
        System.out.println(xOrder);
        if (isAlternating(xOrder) && isAlternating(yOrder)) {
            return true;
        } else if (isAlternating(xOrder) && (rec1[1] == rec2[1] && rec1[3] == rec2[3])) {
            return true;
        } else if (isAlternating(yOrder) && (rec1[0] == rec2[0] && rec1[2] == rec2[2])) {
            return true;
        }
        return (rec1[0] == rec2[0] && rec1[2] == rec2[2]) && (rec1[1] == rec2[1] && rec1[3] == rec2[3]);
    }
}
