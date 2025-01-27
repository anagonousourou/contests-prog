package com.spa.leetcode.easy;

public class FurtherstPointFromOrigin {


    // https://leetcode.com/problems/furthest-point-from-origin/submissions/1484720819/
    public int furthestDistanceFromOrigin(String moves) {
        long nbL = moves.chars().filter(c -> c == 'L').count();
        long nbR = moves.chars().filter(c -> c == 'R').count();
        long nbN = moves.chars().filter(c -> c == '_').count();
        return (int) (Math.abs(nbR - nbL ) + nbN);
    }
}
