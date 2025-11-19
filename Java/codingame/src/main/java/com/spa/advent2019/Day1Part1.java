package com.spa.advent2019;

import com.spa.advent2024.Day1;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Day1Part1 {

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day1.class.getResourceAsStream("/advent2019/day1-input").readAllBytes())
            .lines()
            .toList();
        System.out.println(getTotalFuelPart2(inputLines));
    }

    private static long getTotalFuel(List<String> lines) {
        return lines
            .stream()
            .filter(Predicate.not(String::isBlank))
            .mapToInt(Integer::parseInt)
            .map(i -> (i / 3) - 2)
            .sum();
    }

    private static long getTotalFuelPart2(List<String> lines) {
        return lines
            .stream()
            .filter(Predicate.not(String::isBlank))
            .mapToInt(Integer::parseInt)
            .map(i -> computeFuel(i, -i))
            .sum();
    }

    private static int computeFuel(int currentFuel, int total) {
        if (currentFuel <= 0) {
            return total;
        } else {
            return computeFuel((currentFuel / 3) - 2, total + currentFuel);
        }
    }

    /**
     * @param text A string, containing only ASCII characters, at least one of them is a digit.
     * @return One integer, representing the letter count divided by the digit count.
     */
    public static int divideChars(String text) {
        int letterCount = (int) text
            .chars()
            .filter(i -> Character.isLetter((char) i))
            .count();
        int digitCount = (int) text
            .chars()
            .filter(i -> Character.isDigit((char) i))
            .count();

        return Math.round((float) letterCount / (float) digitCount);
    }
}
