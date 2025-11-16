package com.spa.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumIndexSplit {


    // https://leetcode.com/problems/minimum-index-of-a-valid-split/submissions/1588236555/?envType=daily-question&envId=2025-03-27
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Long> leftOccs = new HashMap<>();
        Map<Integer, Long> rightOccs = new HashMap<>(nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        int dominantElement = rightOccs.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).orElseThrow().getKey();
        for (int i = 0; i < nums.size(); i++) {
            leftOccs.compute(nums.get(i), (k, oldV) -> oldV == null ? 1 : oldV + 1);
            rightOccs.compute(nums.get(i), (k, oldV) -> oldV - 1);

            if (2 * leftOccs.getOrDefault(dominantElement, 0L) > (i + 1)
                && 2 * rightOccs.getOrDefault(dominantElement, 0L) > (nums.size() - 1 - i)){
                return i;
            }
        }
        return -1;
    }
}
