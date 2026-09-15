package com.spa.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

    // https://leetcode.com/problems/repeated-dna-sequences/submissions/2138353713/
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> freqs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(i + 9 < s.length()){
                freqs.compute(s.substring(i, i + 10), (_, value ) -> value == null ? 1 : value + 1);
            }
        }
        return freqs.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
            .toList();
    }
}
