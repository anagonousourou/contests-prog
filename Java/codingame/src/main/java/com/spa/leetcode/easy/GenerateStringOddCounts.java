package com.spa.leetcode.easy;

public class GenerateStringOddCounts {

    // https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/submissions/1643325892/
    public String generateTheString(int n) {
        if(n % 2 == 0){
            return "a".repeat(n - 1) + "b";
        }else{
            return "a".repeat(n);
        }
    }
}
