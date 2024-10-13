package com.spa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PermutationInString {


    // https://leetcode.com/problems/permutation-in-string/submissions/1412520803/
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<String, Long> s1Map = Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> s2Map = null;
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            if (s2Map == null) {
                s2Map = new HashMap<>(Arrays.stream(s2.substring(i, i + s1.length()).split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
            } else {
                String newCharacter = s2.substring(i + s1.length() - 1, i + s1.length());
                String characterOutsideOfRange = s2.substring(i - 1, i);
                s2Map.put(newCharacter, s2Map.getOrDefault(newCharacter, 0L) + 1);
                if(s2Map.get(newCharacter) == 0L){
                    s2Map.remove(newCharacter);
                }
                s2Map.put(characterOutsideOfRange, s2Map.getOrDefault(characterOutsideOfRange, 0L) - 1);
                if(s2Map.get(characterOutsideOfRange) == 0L){
                    s2Map.remove(characterOutsideOfRange);
                }
            }

            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}
