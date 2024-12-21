package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximizeGreatness {

    // https://leetcode.com/problems/maximize-greatness-of-an-array/submissions/1484778463/
    public int maximizeGreatness(int[] nums) {
        //build a hashmap of the occurences
        // and build a hashmap with the nextValue => key is a value appearing in the array and the value if the next value
        // strictly bigger that the key
        Map<Integer, Integer> successors = new HashMap<>();
        Map<Integer, Long> occurences = new HashMap<>(Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        int[] sortedCopy = Arrays.stream(nums).sorted().distinct().toArray();


        for (int i = 0; i < sortedCopy.length - 1; i++) {
            successors.put(sortedCopy[i], sortedCopy[i + 1]);
        }

        int greatness = 0;
        for (int num : nums) {
            int nextSuccessor = nextSuccessor(successors, occurences, num);
            if (nextSuccessor != -1) {
                occurences.put(nextSuccessor, occurences.get(nextSuccessor) - 1);
                greatness++;
            }
        }

        return greatness;
    }

    private int nextSuccessor(Map<Integer, Integer> successors, Map<Integer, Long> occurences, int number) {
        if (successors.containsKey(number) && occurences.get(successors.get(number)) > 0) {
            return successors.get(number);
        } else if (successors.containsKey(number)) {
            return nextSuccessor(successors, occurences, successors.get(number));
        } else {
            return -1;
        }
    }
}
