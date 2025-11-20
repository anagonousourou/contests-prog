package com.spa.leetcode.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SlowestKey {

    // https://leetcode.com/problems/slowest-key/submissions/1582299591/
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        Map<Character, Integer> keys = new HashMap<>();
        for (int i = 0; i < releaseTimes.length; i++) {
            int finalI = i;
            keys.compute(keysPressed.charAt(i), (key, oldValue) -> {
                int newValue = finalI == 0 ? releaseTimes[finalI] : releaseTimes[finalI] - releaseTimes[finalI - 1];
                return oldValue == null ? newValue : Math.max(oldValue, newValue);
            });
        }
        return keys.entrySet().stream()
            .max(Comparator.<Map.Entry<Character, Integer>>comparingInt(Map.Entry::getValue)
                .thenComparing(Map.Entry::getKey)).orElseThrow().getKey();
    }
}
