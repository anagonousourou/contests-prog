package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestInteger {

    // https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/submissions/1474201781/
    public int largestInteger(int num) {
        var digits = String.valueOf(num).chars().map(Character::getNumericValue).toArray();

        for (int i = 0; i < digits.length; i++) {
            int localMaxIndex = i;
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[j] > digits[localMaxIndex] && (digits[i] % 2 == digits[j] % 2)) {
                    localMaxIndex = j;
                }
            }
            if (localMaxIndex != i) {
                int tmp = digits[i];
                digits[i] = digits[localMaxIndex];
                digits[localMaxIndex] = tmp;
            }
        }

        return Integer.parseInt(Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining()));
    }
}
