package com.spa.leetcode.easy;

public class FindMissingRepeatedValues {

    // https://leetcode.com/problems/find-missing-and-repeated-values/submissions/2098721313/
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean[] presence = new boolean[grid.length * grid.length + 1];
        int a = -1;
        int b = -1;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (presence[anInt]) {
                    a = anInt;
                }
                presence[anInt] = true;
            }
        }

        for (int i = 1; i < presence.length; i++) {
            if(!presence[i]){
                b = i;
            }
        }

        return new int[] {a, b};
    }
}
