package com.spa.leetcode;

import java.util.stream.Collectors;

public class ComplementOfBase10Integer {

    //https://leetcode.com/problems/complement-of-base-10-integer/
    public int bitwiseComplement(int n) {
        var complementRep = Integer.toBinaryString(n).chars().mapToObj(i -> i == '1' ? "0" : "1").collect(Collectors.joining());
        return Integer.parseInt(complementRep, 2);
    }
}
