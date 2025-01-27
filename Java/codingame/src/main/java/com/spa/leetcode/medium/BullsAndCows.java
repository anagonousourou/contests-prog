package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

    // https://leetcode.com/problems/bulls-and-cows/submissions/1425264883/
    public String getHint(String secret, String guess) {
        int nbBulls = 0;
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                nbBulls++;
                secretChars[i] = ' ';
                guessChars[i] = ' ';
            }
        }

        int nbCows = intersect(normalize(secretChars), normalize(guessChars));
        return "%dA%dB".formatted(nbBulls, nbCows);

    }

    private static Map<Character, Integer> normalize(char[] input) {
        Map<Character, Integer> result = new HashMap<>(input.length);
        for (var c : input) {
            if (c != ' ') {
                result.put(c, result.getOrDefault(c, 0) + 1);
            }

        }
        return result;
    }

    private static int intersect(Map<Character, Integer> a, Map<Character, Integer> b) {
        int nb = 0;
        for (var entry : a.entrySet()) {
            nb += Math.min(entry.getValue(), b.getOrDefault(entry.getKey(), 0));
        }
        return nb;
    }
}
