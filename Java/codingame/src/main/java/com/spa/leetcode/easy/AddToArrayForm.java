package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddToArrayForm {


    // https://leetcode.com/problems/add-to-array-form-of-integer/submissions/2091174584/
    public List<Integer> addToArrayForm(int[] num, int k) {
        return  Arrays.stream(addStrings(Arrays.stream(num).mapToObj(String::valueOf).collect(Collectors.joining()), String.valueOf(k), 0).split(""))
            .map(Integer::valueOf).toList();
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
