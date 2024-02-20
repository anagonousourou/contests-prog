package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupThePeople {

    //https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        var peopleByGroupSize = IntStream.range(0, groupSizes.length).boxed()
            .collect(Collectors.groupingBy(i -> groupSizes[i], Collectors.toList()));
        List<List<Integer>> result = new ArrayList<>();
        for (var entry : peopleByGroupSize.entrySet()) {
            if (entry.getValue().size() == entry.getKey()) {
                result.add(entry.getValue());
            } else {
                for (int i = 0; i + entry.getKey() <= entry.getValue().size(); i += entry.getKey()) {
                    result.add(entry.getValue().subList(i, i + entry.getKey()));
                }
            }
        }
        return result;
    }
}
