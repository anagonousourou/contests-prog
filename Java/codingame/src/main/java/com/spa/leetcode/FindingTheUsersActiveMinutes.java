package com.spa.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindingTheUsersActiveMinutes {

    //https://leetcode.com/problems/finding-the-users-active-minutes/submissions/1182958805/
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Long> nbUsersForByNbActiveMinutes = Arrays.stream(logs).collect(Collectors.groupingBy(log -> log[0], Collectors.mapping(log -> log[1], Collectors.toSet())))
            .entrySet().stream().map(entry -> Map.entry(entry.getKey(), entry.getValue().size())).collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()));
        int[] result = new int[k];
        for (int i = 1; i <= k; i++) {
            result[i -1] = nbUsersForByNbActiveMinutes.getOrDefault(i,0L).intValue();
        }
        return result;
    }
}
