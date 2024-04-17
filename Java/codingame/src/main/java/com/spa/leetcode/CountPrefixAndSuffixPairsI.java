package com.spa.leetcode;

public class CountPrefixAndSuffixPairsI {

    //https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/submissions/1195527690/
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(isPrefixAndSuffix(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2){
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
