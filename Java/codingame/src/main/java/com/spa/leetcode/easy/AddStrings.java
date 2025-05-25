package com.spa.leetcode.easy;

public class AddStrings {

    // https://leetcode.com/problems/add-strings/submissions/1623868550/
    public String addStrings(String num1, String num2) {
        return addStrings(num1, num2, 0);
    }


    private String addStrings(String num1, String num2, int carryOver) {

        if(num1.isEmpty() && carryOver == 0){
            return num2;
        }
        else if(num1.isEmpty() && carryOver != 0){
            return addStrings(String.valueOf(carryOver), num2, 0);
        }
        else if(num2.isEmpty() && carryOver == 0){
            return num1;
        }
        else if(num2.isEmpty() && carryOver != 0){
            return addStrings(String.valueOf(carryOver), num1, 0);
        }

        int current = Character.getNumericValue(num2.charAt(num2.length() - 1))
            + Character.getNumericValue(num1.charAt(num1.length() - 1))
            + carryOver;
        carryOver = current / 10;
        current = current % 10;
        return addStrings(num1.substring(0, num1.length() - 1), num2.substring(0, num2.length() - 1), carryOver) + String.valueOf(current);
    }


}
