package com.spa.leetcode.easy;

public class ScoreString {

    // https://leetcode.com/problems/score-of-a-string/submissions/1426204688/
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i - 1 >= 0) {
                score += Math.abs(s.charAt(i) - s.charAt(i - 1));
            }
        }
        return score;
    }
}
