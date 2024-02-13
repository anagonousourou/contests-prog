package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacter {

    //https://leetcode.com/problems/first-letter-to-appear-twice/submissions/1166707548/
    public char repeatedCharacter(String s) {
        Map<Character, Integer> occs = new HashMap<>(26);
        for (var c : s.toCharArray()) {
            if (occs.getOrDefault(c, 0) == 1) {
                return c;
            }
            occs.put(c, 1);
        }
        return 'a';
    }
}
