package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> latestCharacters = new HashMap<>();
        Map<Integer, Character> latestPositions = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (latestCharacters.containsKey(s.charAt(i))) {
                int dupPos = latestCharacters.get(s.charAt(i));

                for (int j = dupPos; j >= 0; j--) {
                    Character deleted = latestPositions.remove(j);
                    if (deleted == null) {
                        break;
                    } else {
                        latestCharacters.remove(deleted);
                    }
                }
            }
            latestPositions.put(i, s.charAt(i));
            latestCharacters.put(s.charAt(i), i);

            //System.out.println(latestCharacters);
            maxLength = Math.max(latestCharacters.size(), maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(" lengthOfLongestSubstring pwwkew " + lengthOfLongestSubstring("pwwkew"));
        System.out.println(" lengthOfLongestSubstring bbbbb " + lengthOfLongestSubstring("bbbbb"));
        System.out.println(" lengthOfLongestSubstring '' " + lengthOfLongestSubstring(""));
        System.out.println(" lengthOfLongestSubstring abcabcbb " + lengthOfLongestSubstring("abcabcbb"));
    }
}
