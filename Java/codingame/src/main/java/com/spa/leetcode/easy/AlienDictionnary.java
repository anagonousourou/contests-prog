package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AlienDictionnary {


    // https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/1619100483/
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> lettersPosition = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            lettersPosition.put(order.charAt(i), i);
        }

        Comparator<String> stringComparator = (a, b) -> {
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (lettersPosition.get(a.charAt(i)) > lettersPosition.get(b.charAt(i))) {
                    return 1;
                } else if (lettersPosition.get(a.charAt(i)) < lettersPosition.get(b.charAt(i))) {
                    return -1;
                }
            }
            return Integer.compare(a.length(), b.length());
        };

        return Arrays.equals(words, Arrays.stream(words).sorted(stringComparator).toArray());
    }


    // https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/1619104616/
    public boolean isAlienSorted2(String[] words, String order) {

        Map<Character, Integer> lettersPosition = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            lettersPosition.put(order.charAt(i), i);
        }

        Comparator<String> stringComparator = (a, b) -> {
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (lettersPosition.get(a.charAt(i)) > lettersPosition.get(b.charAt(i))) {
                    return 1;
                } else if (lettersPosition.get(a.charAt(i)) < lettersPosition.get(b.charAt(i))) {
                    return -1;
                }
            }
            return Integer.compare(a.length(), b.length());
        };

        for (int i = 0; i < words.length - 1; i++) {
            if(stringComparator.compare(words[i], words[i + 1]) > 0){
                return false;
            }
        }

        return true;
    }


}
