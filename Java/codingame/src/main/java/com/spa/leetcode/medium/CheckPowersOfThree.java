package com.spa.leetcode.medium;

public class CheckPowersOfThree {


    // https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/submissions/1562372148/?envType=daily-question&envId=2025-03-04
    public boolean checkPowersOfThree(int n) {
        while ((n % 3 == 0 || (n - 1) % 3 == 0) && n != 0){
            if(n % 3 == 0){
                n = n / 3;
            }else{
                n = n - 1;
            }
        }
        return n % 3 == 0;
    }
}
