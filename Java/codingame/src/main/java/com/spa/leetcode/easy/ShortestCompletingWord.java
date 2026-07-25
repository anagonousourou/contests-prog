package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ShortestCompletingWord
 */
public class ShortestCompletingWord {

    // https://leetcode.com/problems/shortest-completing-word/submissions/2073253845/
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Long> occs = occs(licensePlate);

       return Arrays.stream(words).filter(word -> {
          var wordOccs =  occs(word);
          return occs.entrySet().stream()
          .allMatch(entry -> wordOccs.containsKey(entry.getKey()) && wordOccs.get(entry.getKey()) >= entry.getValue());
        }).sorted(Comparator.comparing(String::length)).findFirst().orElseThrow();
    }

	private Map<Character, Long> occs(String string) {
		return string.toLowerCase().chars().filter(Character::isLetter)
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}
