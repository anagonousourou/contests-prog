package com.spa.leetcode;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        char[] schars = s.toCharArray();
        char[] sReversed = new StringBuilder(s).reverse().toString().toCharArray();
        int count = 0;
        for (int i = 0; i < schars.length; i++) {
            if(schars[i] != sReversed[i]){
                count++;
            }
        }
        return count <= 2;
    }
}
