package com.spa.leetcode;

import java.util.stream.Collectors;

public class ReverseBits {

    public int reverseBits(int n) {
        var complementRep = Integer.toBinaryString(n).chars().mapToObj(i -> i == '1' ? "0" : "1").collect(Collectors.joining());
        return Integer.parseInt(complementRep, 2);
    }
}
