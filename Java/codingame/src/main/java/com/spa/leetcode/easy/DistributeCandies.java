package com.spa.leetcode.easy;

import java.util.Arrays;

public class DistributeCandies {


    // https://leetcode.com/problems/distribute-candies/submissions/1537019646/
    public int distributeCandies(int[] candyType) {
        int nbTypes = (int) Arrays.stream(candyType).distinct().count();
        int nbCandies = candyType.length;
        return Math.min(nbCandies / 2, nbTypes);
    }
}
