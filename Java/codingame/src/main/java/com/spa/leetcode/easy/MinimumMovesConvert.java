package com.spa.leetcode.easy;

public class MinimumMovesConvert {

    // https://leetcode.com/problems/minimum-moves-to-convert-string/submissions/1557224090/
    public int minimumMoves(String s) {
        int moves = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'O') {
                i++;
            } else {
                moves++;
                i += 3;
            }
        }
        return moves;
    }
}
