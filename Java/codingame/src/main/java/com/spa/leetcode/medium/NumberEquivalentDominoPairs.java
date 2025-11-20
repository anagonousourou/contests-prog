package com.spa.leetcode.medium;


import java.util.Arrays;
import java.util.Comparator;

public class NumberEquivalentDominoPairs {


    // https://leetcode.com/problems/number-of-equivalent-domino-pairs/submissions/1625116774/?envType=daily-question&envId=2025-05-04
    public int numEquivDominoPairs(int[][] dominoes) {
        for (var domino : dominoes) {
            Arrays.sort(domino);
        }

        Arrays.sort(dominoes, Comparator.<int[]>comparingInt(a -> a[0]).thenComparing(a -> a[1]));


        int count = 0;
        int i = 0;
        while (i < dominoes.length) {
            int j = i + 1;
            while (j < dominoes.length && Arrays.equals(dominoes[i], dominoes[j])) {
                j++;
            }
            count += ((j - i) * (j - i - 1)) / 2;
            i = j;
        }
        return count;
    }
}
