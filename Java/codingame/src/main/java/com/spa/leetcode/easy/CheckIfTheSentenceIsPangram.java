package com.spa.leetcode.easy;

public class CheckIfTheSentenceIsPangram {

    // https://leetcode.com/problems/check-if-the-sentence-is-pangram/submissions/1162911990/

    public boolean checkIfPangram(String sentence) {
        return sentence.chars().distinct().count() == 26;
    }
}
