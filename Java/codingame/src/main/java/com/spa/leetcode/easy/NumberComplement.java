package com.spa.leetcode.easy;

import java.util.stream.Collectors;

public class NumberComplement {

    // https://leetcode.com/problems/number-complement/submissions/1195074573/

    public int findComplement(int n) {
                var complementRep = Integer.toBinaryString(n).chars().mapToObj(i -> i == '1' ? "0" : "1").collect(Collectors.joining());
        return Integer.parseInt(complementRep, 2);
    }
}
