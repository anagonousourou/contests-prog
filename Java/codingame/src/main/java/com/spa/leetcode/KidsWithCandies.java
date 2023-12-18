package com.spa.leetcode;

import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int currentMax = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).map(candy -> candy + extraCandies).mapToObj(newCandies -> newCandies >= currentMax).toList();
    }
}
