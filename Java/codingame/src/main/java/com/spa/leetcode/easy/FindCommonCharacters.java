package com.spa.leetcode.easy;

import com.spa.commonfns.StringHelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {


    // https://leetcode.com/problems/find-common-characters/submissions/1623856535/
    public List<String> commonChars(String[] words) {
        Map<Character, Long> commons = new HashMap<>(StringHelpers.frequencies(words[0]));

        for (int i = 1; i < words.length; i++) {
            var currentWordFreqs = StringHelpers.frequencies(words[i]);
            var it = commons.entrySet().iterator();
            while (it.hasNext()){
                var entry = it.next();
                if(currentWordFreqs.containsKey(entry.getKey())){
                    entry.setValue(Math.min(currentWordFreqs.get(entry.getKey()), entry.getValue()));
                }
                else{
                    it.remove();;
                }
            }
        }

       List<String> result = new ArrayList<>();
        for (var entry : commons.entrySet()){
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }

        return result;
    }
}
