package com.spa.leetcode;

public class ReverseString {

    //https://leetcode.com/problems/reverse-string/
    public void reverseString(char[] charArray) {

        int front = 0;
        int back = charArray.length - 1;
        while (front < back) {
            char tmp = charArray[front];
            charArray[front] = charArray[back];
            charArray[back] = tmp;
            front++;
            back--;
        }
    }
}
