package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumIndexTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexes = new HashMap<>(list1.length);

        Set<String> set2 = Arrays.stream(list2).collect(Collectors.toSet());

        for (int i = 0; i < list1.length; i++) {
            if(set2.contains(list1[i])){
                indexes.putIfAbsent(list1[i], i);
            }
        }

        for (int i = 0; i < list2.length; i++) {
            int finalI = i;
            indexes.computeIfPresent(list2[i], (key, value) -> value + finalI);
        }

        var commonStringsIndexesSum = indexes.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();

        int minIdex = commonStringsIndexesSum.get(0).getValue();

        return commonStringsIndexesSum.stream().takeWhile(entry -> entry.getValue() == minIdex).map(Map.Entry::getKey).toArray(String[]::new);
    }
}
