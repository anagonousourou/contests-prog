package com.spa.leetcode;



public class IsPrefixOfWord {

    //https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/submissions/1195515122/
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if(words[i].startsWith(searchWord)){
                return i + 1;
            }
        }
        return -1;
    }
}
