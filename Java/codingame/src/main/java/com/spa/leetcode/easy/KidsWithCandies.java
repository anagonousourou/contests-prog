package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    // https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/1121727918/

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int currentMax = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).map(candy -> candy + extraCandies).mapToObj(newCandies -> newCandies >= currentMax).toList();
    }
}
