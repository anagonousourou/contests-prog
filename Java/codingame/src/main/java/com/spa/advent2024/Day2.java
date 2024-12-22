package com.spa.advent2024;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day2 {


    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day1.class.getResourceAsStream("/advent2024/day2-input").readAllBytes()).lines()
            .toList();
        int count =  countSafeReportsPart2(inputLines);
        assert count >= 800;
        System.out.println(count);
    }


    private static boolean isSafe(List<Integer> elts) {
        boolean ascending = elts.get(0) < elts.get(1);
        boolean descending = elts.get(0) > elts.get(1);
        if (ascending) {
            for (int i = 0; i < elts.size() - 1; i++) {
                if (elts.get(i) >= elts.get(i + 1) || Math.abs(elts.get(i) - elts.get(i + 1)) > 3) {
                    return false;
                }
            }
            return true;
        }

        if (descending) {
            for (int i = 0; i < elts.size() - 1; i++) {
                if (elts.get(i) <= elts.get(i + 1) || Math.abs(elts.get(i) - elts.get(i + 1)) > 3) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    // part 1
    private static int countSafeReports(List<String> inputLines) {

        int nbsafe = 0;
        for (var line : inputLines) {
            var parts = Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .toList();

            if (isSafe(parts)) {
                nbsafe += 1;
            }
        }

        return nbsafe;
    }


    //part 2


    private static int countSafeReportsPart2(List<String> inputLines) {
        int nbsafe = 0;
        for (var line : inputLines) {
            var parts = Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .toList();

            if (isSafeParts2(parts)) {
                nbsafe += 1;
            }
        }

        return nbsafe;
    }

    private static boolean isSafeParts2(List<Integer> elts) {
        boolean ascending = elts.get(0) < elts.get(1);
        boolean descending = elts.get(0) > elts.get(1);
        if (ascending) {
            int count = 0;
            for (int i = 0; i < elts.size() - 1; i++) {
                if (elts.get(i) >= elts.get(i + 1) || Math.abs(elts.get(i) - elts.get(i + 1)) > 3) {
                    count++;
                }
            }
            return count <= 1;
        }

        if (descending) {
            int count = 0;
            for (int i = 0; i < elts.size() - 1; i++) {
                if (elts.get(i) <= elts.get(i + 1) || Math.abs(elts.get(i) - elts.get(i + 1)) > 3) {
                    count++;
                }
            }
            return count <= 1;
        }

        return false;
    }
}
