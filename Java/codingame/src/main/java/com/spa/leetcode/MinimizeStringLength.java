package com.spa.leetcode;

public class MinimizeStringLength {

    //https://leetcode.com/problems/minimize-string-length/submissions/1173158330/
    public int minimizedStringLength(String s) {
        return (int) s.chars().distinct().count();
    }
}
