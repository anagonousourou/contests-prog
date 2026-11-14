package com.spa.leetcode.easy;

import java.util.stream.Collectors;

public class ReverseBits {

    // https://leetcode.com/problems/reverse-bits/submissions/1921374137/

    public int reverseBits(int n) {
        var complementRep = Integer.toBinaryString(n).chars().mapToObj(i -> i == '1' ? "0" : "1").collect(Collectors.joining());
        return Integer.parseInt(complementRep, 2);
    }
}
