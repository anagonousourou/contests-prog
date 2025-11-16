package com.spa.leetcode.easy;


public class ReorderSpaces {


    // https://leetcode.com/problems/rearrange-spaces-between-words/submissions/1619132864/
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if(" ".equals(text.substring(i , i + 1))){
                spaceCount++;
            }
        }
        if(words.length == 1){
            return words[0] + " ".repeat(spaceCount);
        }
        int nbSpaceMiddle = spaceCount / (words.length - 1);
        int remainder = spaceCount % (words.length - 1);

        return String.join(" ".repeat(nbSpaceMiddle), words) + " ".repeat(remainder);
    }
}
