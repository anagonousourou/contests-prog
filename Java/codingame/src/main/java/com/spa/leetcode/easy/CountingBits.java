package com.spa.leetcode.easy;

import java.util.stream.IntStream;

public class CountingBits {

    // https://leetcode.com/problems/counting-bits/submissions/1122538187/

    public int[] countBits(int n) {
        return IntStream.rangeClosed(0, n).map(Integer::bitCount).toArray();
    }
}
