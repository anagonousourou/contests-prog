package com.spa.leetcode;

import java.util.Arrays;

public class FindSmallestLetterGreaterThanTarget {

    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/1197037558/
    public char nextGreatestLetter(char[] letters, char target) {
        int index = Arrays.binarySearch(letters, target);
        if(index < 0){
            index += 1;
            index = Math.abs(index);
            if(index == letters.length){
                return letters[0];
            }else{
                return letters[index];
            }
        }
        else{
            for (int i = index; i < letters.length; i++) {
                if(letters[i] > letters[index]){
                    return letters[i];
                }
            }
        }
        return letters[0];
    }
}
