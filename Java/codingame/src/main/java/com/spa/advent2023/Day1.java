package com.spa.advent2023;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    static Pattern pattern = Pattern.compile("one|two|three|four|five|six|seven|eight|nine|\\d");

    static Map<String, String> DIGIT_SPELLING = Map.ofEntries(Map.entry("one", "1"), Map.entry("two", "2"),
        Map.entry("three", "3"), Map.entry("four", "4"), Map.entry("five", "5"), Map.entry("six", "6"),
        Map.entry("seven", "7"), Map.entry("eight", "8"), Map.entry("nine", "9"));


    static int sumCalibrationValues(List<String> lines) {
        return lines.stream().map(line -> line.chars().filter(Character::isDigit).mapToObj(i -> (char) i).toList())
            .map(characters -> String.valueOf(characters.get(0)) + String.valueOf(characters.get(characters.size() - 1)))
            .mapToInt(Integer::valueOf).sum();
    }

    static int sumCalibrationValuesPart2(List<String> lines) {
        return lines.stream().map(Day1::getDigits)
            .map(digits -> digits.get(0) + digits.get(digits.size() - 1))
            .mapToInt(Integer::valueOf).sum();
    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day1.class.getResourceAsStream("/advent2023/day1part1/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(sumCalibrationValuesPart2(inputLines));

        getDigits("xcntwone4633sixmkm1nine");
    }

    static List<String> getDigits(String line) {
        Matcher matcher = pattern.matcher(line);
        List<String> digits = new ArrayList<>();
        int startAt = 0;
        while (matcher.find(startAt)) {
            startAt = matcher.start() + 1;
            digits.add(DIGIT_SPELLING.getOrDefault(matcher.group(), matcher.group()));
        }
        System.out.println(digits);
        return digits;
    }

    static <K, V> V getOrDefault(Map<K, V> map, K key, Supplier<V> defaultExpression) {
        return (map.containsKey(key)) ? map.get(key) : defaultExpression.get();
    }
}
