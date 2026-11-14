package com.spa.leetcode.medium;

import java.util.Set;

public class MaxNumbersOfVowel {

    // https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/2194722368/?envType=study-plan-v2&envId=leetcode-75
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int[] prefixSum = new int[s.length()];
        prefixSum[0] = VOWELS.contains(s.charAt(0)) ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            prefixSum[i] = prefixSum[i - 1] + (VOWELS.contains(s.charAt(i)) ? 1 : 0);
        }

        int vowelCount = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int sum = prefixSum[i + k - 1] - ((i - 1) >= 0 ? prefixSum[i - 1] : 0);
            vowelCount = Math.max(vowelCount, sum);
        }
        return vowelCount;
    }
}
