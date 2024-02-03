package com.spa.leetcode;

import java.util.Set;

public class StringHalvesAreAlike {

    //https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(String s) {
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);
        return firstHalf.chars().mapToObj(c -> (char) c).filter(c -> vowels.contains(c)).count() ==
            secondHalf.chars().mapToObj(c -> (char) c).filter(c -> vowels.contains(c)).count();
    }
}
