package com.spa.leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostVisitedSectors {

    // https://leetcode.com/problems/most-visited-sector-in-a-circular-track/submissions/1527425754/
    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> visitsBySector = new HashMap<>();

        for (int i = 1; i < rounds.length; i++) {
            for (int j = rounds[i - 1]; j != rounds[i]; j = j == n ? 1 : j + 1) {
                visitsBySector.put(j, visitsBySector.getOrDefault(j, 0) + 1);
            }
        }

        visitsBySector.put(rounds[rounds.length - 1], visitsBySector.getOrDefault(rounds[rounds.length - 1], 0) + 1);

        return visitsBySector.entrySet().stream().filter(entry -> entry.getValue() ==
                visitsBySector.values().stream().mapToInt(Integer::intValue).max().orElse(0))
            .map(Map.Entry::getKey).sorted().toList();
    }
}
