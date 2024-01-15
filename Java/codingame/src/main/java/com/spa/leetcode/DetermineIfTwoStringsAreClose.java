package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.*;

//https://leetcode.com/problems/determine-if-two-strings-are-close/description/
public class DetermineIfTwoStringsAreClose {

    //https://leetcode.com/problems/determine-if-two-strings-are-close/
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Long> word1Freqs = new HashMap<>(StringHelpers.frequencies(word1));
        Map<Character, Long> word2Freqs = new HashMap<>(StringHelpers.frequencies(word2));

        Set<Character> okChars = new HashSet<>();
        while (!word1Freqs.equals(word2Freqs)){
           var chOccs = word1Freqs.entrySet().stream().filter(entry -> !okChars.contains(entry.getKey())).sorted(Map.Entry.comparingByValue())
                .toList();
           Map.Entry<Character, Long> occ = chOccs.get(0);
           if(!word2Freqs.containsKey(occ.getKey())){
               return false;
           }
           else if(word2Freqs.get(occ.getKey()).longValue() == occ.getValue().longValue()){
               okChars.add(occ.getKey());
           }
           else{
               Long charOccInWord2 = word2Freqs.get(occ.getKey());
               var swapCandidates = chOccs.stream().filter(entry -> entry.getValue().equals(charOccInWord2)).toList();
               if(swapCandidates.isEmpty()){
                   return false;
               }else{
                   Map.Entry<Character, Long> swapCandidate = swapCandidates.get(0);
                   word1Freqs.put(swapCandidate.getKey(), occ.getValue());
                   word1Freqs.put(occ.getKey(), charOccInWord2);
                   okChars.add(occ.getKey());
               }
           }
        }
        return true;
    }
}
