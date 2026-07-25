package com.spa.leetcode.easy;

public class AddBinary {

    // https://leetcode.com/problems/add-binary/submissions/1920060747/?envType=daily-question&envId=2026-02-15
    public String addBinary(String a, String b) {
        return addStrings(a, b, 0);
    }


    private String addStrings(String num1, String num2, int carryOver) {

        if (num1.isEmpty() && carryOver == 0) {
            return num2;
        } else if (num1.isEmpty() && carryOver != 0) {
            return addStrings(String.valueOf(carryOver), num2, 0);
        } else if (num2.isEmpty() && carryOver == 0) {
            return num1;
        } else if (num2.isEmpty() && carryOver != 0) {
            return addStrings(String.valueOf(carryOver), num1, 0);
        }

        int current = Character.getNumericValue(num2.charAt(num2.length() - 1))
            + Character.getNumericValue(num1.charAt(num1.length() - 1))
            + carryOver;
        carryOver = current / 2;
        current = current % 2;
        return addStrings(num1.substring(0, num1.length() - 1), num2.substring(0, num2.length() - 1), carryOver) + current;
    }
}
