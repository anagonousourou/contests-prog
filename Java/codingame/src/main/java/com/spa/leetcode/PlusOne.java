package com.spa.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        return new BigInteger(Arrays.stream(digits).mapToObj(String::valueOf).reduce("", (a, b) -> a + b))
            .add(BigInteger.ONE)
            .toString().chars().mapToObj(c -> (char) c).map(String::valueOf).mapToInt(Integer::parseInt).toArray();
    }
}
