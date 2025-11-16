package com.spa.leetcode.medium;

public class DominoRotations {

    // https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/1624199139/?envType=daily-question&envId=2025-05-03
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] dominoOccurrences = new int[7];

        for (int i = 0; i < tops.length; i++) {
            dominoOccurrences[tops[i]] += 1;
            if(bottoms[i]!= tops[i]){
                dominoOccurrences[bottoms[i]] += 1;
            }
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i < dominoOccurrences.length; i++) {
            if(dominoOccurrences[i] == tops.length){
                //try top
                int topRotations = 0;
                for (int top : tops) {
                    if (top != i) {
                        topRotations++;
                    }
                }

                //try bottom
                int bottomRotations = 0;
                for (int bottom : bottoms) {
                    if (bottom != i) {
                        bottomRotations++;
                    }
                }

                minimum = Math.min(minimum, Math.min(bottomRotations, topRotations));

            }
        }

        return minimum != Integer.MAX_VALUE ? minimum : -1;
    }
}
