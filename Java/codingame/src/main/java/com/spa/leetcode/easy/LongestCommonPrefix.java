package com.spa.leetcode.easy;

public class LongestCommonPrefix {

    // https://leetcode.com/problems/longest-common-prefix/submissions/825433757/

        public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        
        while (true) {
            if (strs[0].isEmpty()) {//if the first element becomes empty
                return prefix.toString();
            }
            String firstCharacter = strs[0].substring(0, 1);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].isEmpty()) {
                    return prefix.toString();
                }
                if (!strs[i].substring(0, 1).equals(firstCharacter)) {
                    return prefix.toString();
                }

                strs[i] = strs[i].substring(1);
                
            }
            prefix.append(firstCharacter);
        }

    }
}
