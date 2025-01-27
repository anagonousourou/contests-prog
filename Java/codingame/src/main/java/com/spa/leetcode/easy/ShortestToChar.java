package com.spa.leetcode.easy;

import java.util.Arrays;

public class ShortestToChar {


    // https://leetcode.com/problems/shortest-distance-to-a-character/submissions/1478028181/
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];

        Arrays.fill(answer, Integer.MAX_VALUE);
        int distanceToC = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                distanceToC = 0;
            } else if (distanceToC != Integer.MAX_VALUE) {
                distanceToC += 1;
            }
            answer[i] = Math.min(distanceToC, answer[i]);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                distanceToC = 0;
            } else if (distanceToC != Integer.MAX_VALUE) {
                distanceToC += 1;
            }
            answer[i] = Math.min(distanceToC, answer[i]);
        }
        return answer;
    }
}
