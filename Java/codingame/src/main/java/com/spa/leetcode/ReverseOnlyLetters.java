package com.spa.leetcode;

public class ReverseOnlyLetters {

    //https://leetcode.com/problems/reverse-only-letters/
    public String reverseOnlyLetters(String s) {
        char[] charArray = s.toCharArray();

        int front = 0;
        int back = charArray.length - 1;
        while (front < back) {
            if (!Character.isLetter(charArray[front])) {
                front++;
            } else if (!Character.isLetter(charArray[back])) {
                back--;
            } else {
                char tmp = charArray[front];
                charArray[front] = charArray[back];
                charArray[back] = tmp;
                front++;
                back--;
            }

        }

        return new String(charArray);
    }
}
