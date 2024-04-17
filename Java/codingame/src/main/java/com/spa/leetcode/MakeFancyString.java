package com.spa.leetcode;

public class MakeFancyString {

    //https://leetcode.com/problems/delete-characters-to-make-fancy-string/submissions/1200325354/
    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char currentChar = s.charAt(0);
        int currentCharCount = 1;
        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == currentChar){
                currentCharCount++;
            }else{
                currentCharCount = 1;
                currentChar = s.charAt(i);
            }
            if(currentCharCount < 3){
                stringBuilder.append(currentChar);
            }
        }
        return stringBuilder.toString();
    }
}
