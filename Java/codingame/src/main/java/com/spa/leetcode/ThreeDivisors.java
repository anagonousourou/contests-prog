package com.spa.leetcode;

import java.util.stream.IntStream;

public class ThreeDivisors {

    //https://leetcode.com/problems/three-divisors/description/
    public boolean isThree(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0 ).count() == 3;
    }
}
