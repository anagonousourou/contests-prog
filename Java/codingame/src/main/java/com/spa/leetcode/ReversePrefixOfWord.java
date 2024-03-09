package com.spa.leetcode;

public class ReversePrefixOfWord {


    //https://leetcode.com/problems/reverse-prefix-of-word/
    public String reversePrefix(String word, char ch) {
        int chIndex = word.indexOf(ch);
        return new StringBuilder(word.substring(0, chIndex + 1)).reverse().append(word.substring(chIndex + 1)).toString();
    }
}
