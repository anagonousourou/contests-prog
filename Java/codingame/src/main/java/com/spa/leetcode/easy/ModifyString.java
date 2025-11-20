package com.spa.leetcode.easy;

public class ModifyString {

    // https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/submissions/1623801126/
    public String modifyString(String s) {
        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if(letters[i] == '?'){
                char candidate = 'a';
                while ((i - 1 >= 0 && candidate == letters[i - 1]) || (i + 1 < letters.length && candidate == letters[i + 1])){
                    candidate = (char) (candidate + 1);
                }
                letters[i] = candidate;
            }
        }
        return new String(letters);
    }
}
