package com.spa.leetcode.easy;

public class EvenOddBit {

    // https://leetcode.com/problems/number-of-even-and-odd-bits/submissions/1584211954/
    public int[] evenOddBit(int n) {
        String s = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();

        int even = 0;
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i % 2 == 0 && s.charAt(i) == '1'){
                even++;
            }

            if(i % 2 == 1 && s.charAt(i) == '1'){
                odd++;
            }
        }

        return new int[]{even, odd};
    }
}
