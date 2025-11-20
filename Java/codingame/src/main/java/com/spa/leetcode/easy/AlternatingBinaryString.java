package com.spa.leetcode.easy;

public class AlternatingBinaryString {

    // https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/submissions/1643322039/
    public int minOperations(String s) {
        if(s.length() == 1){
            return 0;
        }

        int lastDigit = s.charAt(0);
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == lastDigit){
                count++;
                lastDigit = lastDigit == '0' ? '1' : '0';
            }else{
                lastDigit = s.charAt(i);
            }
        }

        lastDigit = s.charAt(0) == '0' ? '1' : '0';
        int count2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == lastDigit){
                count2++;
                lastDigit = lastDigit == '0' ? '1' : '0';
            }else{
                lastDigit = s.charAt(i);
            }
        }
        return Math.min(count2, count);
    }
}
