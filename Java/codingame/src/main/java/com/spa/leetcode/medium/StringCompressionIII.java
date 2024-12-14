package com.spa.leetcode.medium;

public class StringCompressionIII {


    // https://leetcode.com/problems/string-compression-iii/submissions/1442531262/?envType=daily-question&envId=2024-11-04
    public String compressedString(String word) {
        StringBuilder builder = new StringBuilder();
        char currentChar = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (count == 9 || currentChar != word.charAt(i)) {
                builder.append(count);
                builder.append(currentChar);
                count = 1;
                currentChar = word.charAt(i);
            } else if (currentChar == word.charAt(i)) {
                count++;
            }
        }
        builder.append(count);
        builder.append(currentChar);
        return builder.toString();
    }
}
