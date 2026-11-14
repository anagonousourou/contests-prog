package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    // https://leetcode.com/problems/fizz-buzz/submissions/827289041/

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for (int index = 1; index <= n; index++) {
            if (index % 15 == 0) {
                result.add("FizzBuzz");
            } else if (index % 5 == 0) {
                result.add("Buzz");
            } else if (index % 3 == 0) {
                result.add("Fizz");
            } else{
                result.add(String.valueOf(index));
            }
        }

        return result;
    }
}
