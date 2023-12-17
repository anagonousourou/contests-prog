package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/">...</a>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return StringHelpers.isPalindrome(String.valueOf(x));
    }
}
