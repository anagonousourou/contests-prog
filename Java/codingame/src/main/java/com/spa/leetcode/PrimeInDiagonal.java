package com.spa.leetcode;

public class PrimeInDiagonal {

    // https://leetcode.com/problems/prime-in-diagonal/submissions/1415183380/
    public int diagonalPrime(int[][] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(isPrime(nums[i][i])){
                res = Math.max(res, nums[i][i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(isPrime(nums[i][nums.length - 1 - i])){
                res = Math.max(res, nums[i][nums.length - 1 - i]);
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
