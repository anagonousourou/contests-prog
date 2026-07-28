package com.spa.leetcode.medium;

import java.util.Arrays;

/**
 * SmallestPalindrome
 */
public class SmallestPalindrome {

    // https://leetcode.com/problems/smallest-palindromic-rearrangement-i/submissions/2084966669/?envType=daily-question&envId=2026-07-28
    public String smallestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }else if(s.length() % 2 == 1){
            String[] characters = s.substring(0, s.length() / 2).split("");
            Arrays.sort(characters);
            String left = String.join("", characters) ;
            return left + s.charAt(s.length() / 2) + new StringBuilder(left).reverse().toString();
        }else{
            String[] characters = s.substring(0, s.length() / 2).split("");
            Arrays.sort(characters);
            String left = String.join("", characters) ;
            return left + new StringBuilder(left).reverse().toString();
        }
    }
}
