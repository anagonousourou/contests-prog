package com.spa.advent2024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day1 {


    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day1.class.getResourceAsStream("/advent2024/day1-input").readAllBytes()).lines()
            .toList();
        System.out.println(getSimilarityScoreDifference(inputLines));
    }


    // part 1
    private static int getDifference(List<String> inputLines) {
        List<Integer> left = new ArrayList<>(inputLines.size());
        List<Integer> right = new ArrayList<>(inputLines.size());

        for (var line : inputLines) {
            var parts = line.split("\\s+");
            left.add(Integer.valueOf(parts[0]));
            right.add(Integer.valueOf(parts[1]));
        }

        Collections.sort(left);
        Collections.sort(right);
        int diff = 0;
        for (int i = 0; i < left.size(); i++) {
            diff += Math.abs(left.get(i) - right.get(i));
        }
        return diff;
    }

    // part 2
    private static long getSimilarityScoreDifference(List<String> inputLines) {
        List<Integer> left = new ArrayList<>(inputLines.size());
        List<Integer> right = new ArrayList<>(inputLines.size());

        for (var line : inputLines) {
            var parts = line.split("\\s+");
            left.add(Integer.valueOf(parts[0]));
            right.add(Integer.valueOf(parts[1]));
        }

        var occurences = right.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return left.stream().mapToLong(elt -> occurences.getOrDefault(elt, 0L) * elt).sum();
    }
}
