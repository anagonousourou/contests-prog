package com.spa.leetcode;

public class DifferenceOfSums {

    //https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
    public int differenceOfSums(int n, int m) {

        int num2 = 0;
        int i = 1;
        while (i * m <= n){
            num2 += i * m;
            i++;
        }

        System.out.println("nums2 = "+ num2);

        int num1 = ((n * (n + 1)) / 2)  - num2;
        System.out.println("nums1 = "+ num1);
        return num1 - num2;
    }
}
