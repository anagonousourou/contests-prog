package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningPlayerCount {

    // https://leetcode.com/problems/find-the-number-of-winning-players/submissions/1560266100/
    public int winningPlayerCount(int n, int[][] pick) {
        return (int) Arrays.stream(pick)
            .collect(Collectors.toMap(elt -> elt[0], elt -> new HashMap<>(Map.of(elt[1], 1)), (map1, map2) -> {
                map2.forEach((key, value) -> {
                    map1.merge(key, value, Integer::sum);
                });
                return map1;
            }))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue().values().stream().anyMatch(count -> count > entry.getKey()))
            .count();
    }
}
