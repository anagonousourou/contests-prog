package com.spa.leetcode;

public class ValidPalindrome {


    //https://leetcode.com/problems/valid-palindrome/submissions/1197043277/
    public boolean isPalindrome(String s) {
       String simplified = s.toLowerCase().replaceAll("\\s+|[^a-z0-9]", "");
       return simplified.equals(new StringBuilder(simplified).reverse().toString());
    }
}
