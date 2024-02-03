package com.spa.leetcode;

public class ValidPerfectSquare {


    public static boolean isPerfectSquare(int num) {

        if (num <= 1) {
            return true;
        }

        long l = 0;
        long r = num;
        while (l <= r) {

            long middle = (l + r) / 2;
            System.out.println(String.format("l = %d, r = %d, middle = %d", l, r, middle));
            if (middle * middle == num) {
                return true;
            }
            if (l == middle && r == middle) {
                break;
            }

            if (middle * middle < num && l != middle) {
                l = middle;
            } else {
                r = middle;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println("Result  isSquare(2147483647) =  " + isPerfectSquare(2147483647));
        //System.out.println("Result  isSquare(4) =  " + isPerfectSquare(4));

        System.out.println("Result  isSquare(5) =  " + isPerfectSquare(5));
        //System.out.println("Result  isSquare(1) =  " + isPerfectSquare(1));
        //System.out.println("Result  isSquare(16) =  " + isPerfectSquare(16));
        //System.out.println("Result  isSquare(49) =  " + isPerfectSquare(49));
    }

    public boolean isPerfectSquare2(int num) {

        for (int i = 1; i <= num; i++) {
            if (i * i == num) {
                return true;
            }
            if (i * i > num) {
                break;
            }
        }
        return false;
    }
}
