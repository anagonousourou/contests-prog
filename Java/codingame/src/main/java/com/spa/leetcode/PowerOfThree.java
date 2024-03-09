package com.spa.leetcode;

public class PowerOfThree {


    //https://leetcode.com/problems/power-of-three/submissions/1190478974/
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    //https://leetcode.com/problems/power-of-three/solutions/77856/1-line-java-solution-without-loop-recursion/
    //We can use this method to judge power of 2, 3, 5, 7, 11, ... since they are prime numbers.
    public boolean isPowerOfThreeV2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than Integer.MAX
        return (n > 0 && 1162261467 % n == 0);
    }
}
