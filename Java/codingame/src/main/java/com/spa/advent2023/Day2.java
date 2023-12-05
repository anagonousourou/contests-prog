package com.spa.advent2023;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day2 {

    private static Pattern DIGIT = Pattern.compile("\\d+");
    private static Map<String, Integer> LIMITS = Map.of("red", 12, "blue", 14, "green", 13);

    static
    record Game(int id, List<Map<String, Integer>> gameTurnResults) {
    }

    static int processPart1(List<String> lines) {
        return lines.stream().map(line -> {
            String[] parts = line.split(":");
            var gameIdMatcher = DIGIT.matcher(parts[0]);
            int gameId = 0;
            if (gameIdMatcher.find()) {
                gameId = Integer.parseInt(gameIdMatcher.group());
            }
            var gameTurnResults = Arrays.stream(parts[1].trim().split(";")).map(gameTurnResult -> Arrays.stream(gameTurnResult.trim().split(","))
                .map(colorCount -> {
                    List<String> countAndColor = Arrays.stream(colorCount.trim().split(" "))
                        .map(String::trim).filter(Predicate.not(String::isBlank)).toList();
                    String color = countAndColor.get(1);
                    int count = Integer.parseInt(countAndColor.get(0));
                    return Map.entry(color, count);
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))).toList();
            var game = new Game(gameId, gameTurnResults);
            return game;
        }).filter(game -> game.gameTurnResults.stream().allMatch(gameTurnResult -> gameTurnResult.entrySet().stream()
            .allMatch(entry -> LIMITS.get(entry.getKey()) >= entry.getValue()))).mapToInt(Game::id).sum();
    }

    static int processPart2(List<String> lines) {
        return lines.stream().map(line -> {
                String[] parts = line.split(":");
                var gameIdMatcher = DIGIT.matcher(parts[0]);
                int gameId = 0;
                if (gameIdMatcher.find()) {
                    gameId = Integer.parseInt(gameIdMatcher.group());
                }
                var gameTurnResults = Arrays.stream(parts[1].trim().split(";")).map(gameTurnResult -> Arrays.stream(gameTurnResult.trim().split(","))
                    .map(colorCount -> {
                        List<String> countAndColor = Arrays.stream(colorCount.trim().split(" "))
                            .map(String::trim).filter(Predicate.not(String::isBlank)).toList();
                        String color = countAndColor.get(1);
                        int count = Integer.parseInt(countAndColor.get(0));
                        return Map.entry(color, count);
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))).toList();
                return new Game(gameId, gameTurnResults);
            })
            .map(game -> game.gameTurnResults().stream().reduce(new HashMap<>(), Day2::mergeMapWithMax))
            .mapToInt(maxmap -> maxmap.values().stream().reduce((a, b) -> a * b).orElseThrow())
            .sum();

    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day2.class.getResourceAsStream("/advent2023/day2/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart2(inputLines));
    }

    static Map<String, Integer> mergeMapWithMax(Map<String, Integer> map1, Map<String, Integer> map2) {
        Set<String> keys = new HashSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        Map<String, Integer> resultMap = new HashMap<>();

        for (String key : keys) {
            resultMap.put(key, Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0)));
        }
        return resultMap;
    }


}
