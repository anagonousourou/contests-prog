package com.spa.leetcode;

public class Maximum69Number {

    //https://leetcode.com/problems/maximum-69-number/
    public int maximum69Number (int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '6'){
                charArray[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(charArray));
    }
}
