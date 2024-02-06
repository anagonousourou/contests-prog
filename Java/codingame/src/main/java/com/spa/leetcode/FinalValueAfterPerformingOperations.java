package com.spa.leetcode;

import java.util.Arrays;

public class FinalValueAfterPerformingOperations {

    //https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/

    public int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations).mapToInt(op ->
            switch (op) {
                case "++X" -> 1;
                case "X++" -> 1;
                case "--X" -> -1;
                case "X--" -> -1;
                default -> 0;
            }).sum();
    }
}
