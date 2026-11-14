package com.spa.leetcode.easy;

import com.spa.commonfns.StringHelpers;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/submissions/1841033203/">...</a>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return StringHelpers.isPalindrome(String.valueOf(x));
    }
}
