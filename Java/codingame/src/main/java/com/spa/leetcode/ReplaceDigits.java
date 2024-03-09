package com.spa.leetcode;

public class ReplaceDigits {

    //https://leetcode.com/problems/replace-all-digits-with-characters/
    public String replaceDigits(String s) {
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i += 2) {
            array[i] = (char) (array[i - 1] + Character.getNumericValue(array[i]));
        }
        return new String(array);
    }
}
