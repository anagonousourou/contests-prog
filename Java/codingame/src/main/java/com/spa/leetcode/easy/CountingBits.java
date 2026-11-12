package com.spa.leetcode.easy;

import java.util.stream.IntStream;

public class CountingBits {

    public int[] countBits(int n) {
        return IntStream.rangeClosed(0, n).map(Integer::bitCount).toArray();
    }
}
