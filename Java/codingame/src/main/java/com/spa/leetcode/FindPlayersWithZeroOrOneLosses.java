package com.spa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPlayersWithZeroOrOneLosses {

    //https://leetcode.com/problems/find-players-with-zero-or-one-losses/
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> allPlayers = new HashSet<>();
        Map<Integer, Integer> losers = new HashMap<>();

        for (int[] match : matches) {
            allPlayers.add(match[0]);
            allPlayers.add(match[1]);
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
        }

        var answer0 = allPlayers.stream().filter(player -> !losers.containsKey(player)).sorted().toList();
        var answer1 = allPlayers.stream().filter(player -> losers.getOrDefault(player, 0) == 1).sorted().toList();
        return List.of(answer0, answer1);
    }
}
