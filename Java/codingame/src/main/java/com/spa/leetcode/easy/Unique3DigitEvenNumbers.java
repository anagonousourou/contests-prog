package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Unique3DigitEvenNumbers {

    // https://leetcode.com/problems/unique-3-digit-even-numbers/submissions/1586959832/
    public int totalNumbers(int[] digits) {
        int[] evenDigits = Arrays.stream(digits).filter(n -> n % 2 == 0).distinct().toArray();
        int[] nonZeros = Arrays.stream(digits).filter(n -> n != 0).distinct().toArray();
        int[] distinctDigits = Arrays.stream(digits).distinct().toArray();
        Map<Integer, Long> occs = Arrays.stream(digits).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int sum = 0;
        for (int evenDigit : evenDigits) {
            for (int digit1 : nonZeros) {
                if (digit1 != evenDigit || occs.get(evenDigit) > 1) {
                    for (int digit2 : distinctDigits) {
                        if ((digit2 == evenDigit && digit2 != digit1 && occs.get(evenDigit) > 1)
                            || (digit2 != evenDigit && digit2 == digit1 && occs.get(digit1) > 1)
                            || (digit2 == evenDigit && digit2 == digit1 && occs.get(evenDigit) > 2)
                            || (digit2 != evenDigit && digit2 != digit1)) {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }



}
