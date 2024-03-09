package com.spa.leetcode;

public class MaximumOddBinaryNumber {

    //https://leetcode.com/problems/maximum-odd-binary-number/?envType=daily-question&envId=2024-03-01
    public String maximumOddBinaryNumber(String s) {
        int totalLength = s.length();
        int oneCount = (int) s.chars().filter(c -> (char)c == '1').count();
        int zeroCount = totalLength - oneCount;

        return "1".repeat(oneCount -1) + "0".repeat(zeroCount) + "1";
     }
}
