package com.spa.leetcode.easy;

public class SumZero {


    // https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/submissions/1474186119/
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int nbpositives = n / 2;

        int sum = 0;
        for (int i = 0; i < nbpositives; i++) {
            result[i] = i + 1;
            sum += i + 1;
        }
        int j = 0;
        for (int i = nbpositives; i < n - 1; i++) {
            result[i] = -(j + 1);
            sum -= (j + 1);
            j++;
        }
        result[n - 1] = -sum;

        return result;
    }
}
