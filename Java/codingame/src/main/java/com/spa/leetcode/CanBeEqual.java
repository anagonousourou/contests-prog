package com.spa.leetcode;

public class CanBeEqual {

    //TODO
    public boolean canBeEqual(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        for (int i = 0; i < s1arr.length; i++) {
            if(s1arr[i] != s2arr[i]){
                if(i + 2 < s1arr.length){
                    s2arr[i] = s1arr[i + 2];
                }

            }
        }
        return true;
    }
}
