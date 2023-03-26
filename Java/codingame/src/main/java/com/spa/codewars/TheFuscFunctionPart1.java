package com.spa.codewars;

//https://www.codewars.com/kata/570409d3d80ec699af001bf9/train/java
public class TheFuscFunctionPart1 {
    public static int fusc(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return fusc(n / 2);
        } else {
            return fusc(n / 2) + fusc(n / 2 + 1);
        }
    }
}
