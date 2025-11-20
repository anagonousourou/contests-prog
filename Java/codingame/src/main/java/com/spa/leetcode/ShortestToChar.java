package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShortestToChar {

    // TODO https://leetcode.com/problems/shortest-distance-to-a-character/
    public int[] shortestToChar(String s, char c) {
        List<Integer> cpositions = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c){
                cpositions.add(i);
            }
        }
        return new int[0];
    }
}
