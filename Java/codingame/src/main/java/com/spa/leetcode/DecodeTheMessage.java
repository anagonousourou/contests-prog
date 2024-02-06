package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {
        List<Character> keys = key.chars().filter(c -> (char) c != ' ').distinct().mapToObj(c -> (char) c).toList();
        Map<Character, Character> mapping = new HashMap<>(26);

        for (int i = 0; i < keys.size(); i++) {
            mapping.put(keys.get(i), StringHelpers.ALPHABET.charAt(i));
        }

        return message.chars().mapToObj(c -> (char) c).map(c -> mapping.getOrDefault(c, c)).map(String::valueOf).collect(Collectors.joining());
    }
}
