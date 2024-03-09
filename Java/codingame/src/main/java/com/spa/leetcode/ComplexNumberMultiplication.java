package com.spa.leetcode;



public class ComplexNumberMultiplication {

    //https://leetcode.com/problems/complex-number-multiplication
    //https://en.wikipedia.org/wiki/Complex_number
    public String complexNumberMultiply(String num1, String num2) {
        int[] parts1 = getParts(num1);
        int[] parts2 = getParts(num2);

        return String.format("%d+%di", parts1[0] * parts2[0] - parts1[1] * parts2[1], parts1[0] * parts2[1] + parts1[1] * parts2[0]);
    }

    private int[] getParts(String num1) {
        int a = Integer.parseInt(num1.substring(0, num1.indexOf("+")));
        int b = Integer.parseInt(num1.substring(num1.indexOf("+") + 1, num1.length() - 1));
        return new int[]{a, b};
    }
}
