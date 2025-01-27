package com.spa.leetcode.easy;

public class RotateString {


    // https://leetcode.com/problems/rotate-string/submissions/1474379284/
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        return rotateString(0, s, goal);
    }

    public boolean rotateString(int nb, String s, String goal) {
        if (nb > s.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        return rotateString(nb + 1, s.substring(1) + s.substring(0, 1), goal);
    }
}
