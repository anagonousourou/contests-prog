package com.spa.leetcode.easy;

public class CountKConstraintSubstrings {

    // https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/submissions/1792046970/
    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                int count0 = 0;
                int count1 = 0;

                for (char c : substring.toCharArray()){
                    count1 += c == '1' ? 1 : 0;
                    count0 += c == '0' ? 1 : 0;
                }
                if(count1 <= k || count0 <= k){
                    count++;
                }
            }
        }
        return count;
    }


}
