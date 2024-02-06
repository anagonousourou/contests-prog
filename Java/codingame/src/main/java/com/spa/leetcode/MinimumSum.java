package com.spa.leetcode;


//https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/
public class MinimumSum {

    public int minimumSum(int num) {
        var digits = String.valueOf(num).chars().sorted()
            .mapToObj(c -> (char)c).map(String::valueOf).toList();

        int num1 = Integer.parseInt(digits.get(0) + digits.get(2));
        int num2 = Integer.parseInt(digits.get(1) + digits.get(3));

        return num1 + num2;
    }
}
