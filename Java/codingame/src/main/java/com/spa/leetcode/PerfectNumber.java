package com.spa.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PerfectNumber {

    //https://leetcode.com/problems/perfect-number/submissions/1232345559/
    public boolean checkPerfectNumber(int num) {
        //return IntStream.range(1, num).filter(i -> num % i == 0).sum() == num;

        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0 && i != num) {
                sum += i;
                if (num / i != num) {
                    sum += num / i;
                }

            }
        }
        return sum == num;
    }
}
