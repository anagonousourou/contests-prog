package com.spa.leetcode.easy;

public class CircularSentence {

    // https://leetcode.com/problems/circular-sentence/submissions/1430364970/
    public boolean isCircularSentence(String sentence) {
        var words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            int nextIndex = (i + 1) % words.length;
            if (words[i].charAt(words[i].length() - 1) != words[nextIndex].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
