package com.spa.leetcode;

public class MakeThreeStringsEqual {

    //https://leetcode.com/problems/make-three-strings-equal/submissions/1233403211/
    public int findMinimumOperations(String s1, String s2, String s3) {
        int l = Math.min(s2.length(), s1.length());
        l = Math.min(s3.length(), l);
        int i = 0;
        for (i = 0; i < l; i++) {
            if(s1.charAt(i) != s2.charAt(i) || s1.charAt(i) != s3.charAt(i)){
                break;
            }
        }

        if(i == 0){
            return -1;
        }
        return s1.length() + s2.length() + s3.length() - 3 * i;
    }
}
