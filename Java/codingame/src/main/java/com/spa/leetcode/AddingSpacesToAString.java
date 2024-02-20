package com.spa.leetcode;

public class AddingSpacesToAString {

    //https://leetcode.com/problems/adding-spaces-to-a-string/
    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder(s);

        int nb = 0;
        for (int space : spaces) {
            stringBuilder.insert(space + nb, " ");
            nb++;
        }
        return stringBuilder.toString();
    }

    //Version plus rapide
    public String addSpacesV2(String s, int[] spaces) {
        if (spaces.length == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                stringBuilder.append(" ");
                j++;
                stringBuilder.append(s.charAt(i));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
