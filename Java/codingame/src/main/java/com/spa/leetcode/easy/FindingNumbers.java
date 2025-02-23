package com.spa.leetcode.easy;

import java.util.stream.IntStream;

public class FindingNumbers {


    // https://leetcode.com/problems/finding-3-digit-even-numbers/submissions/1549738345/
    public int[] findEvenNumbers(int[] digits) {
        int[] freqs = new int[10];
        for (var digit : digits) {
            freqs[digit] += 1;
        }
        return IntStream.rangeClosed(100, 999)
            .filter(i -> i % 2 == 0 && canBeBuiltFrom(digitFreq(i), freqs))
            .toArray();
    }

    boolean canBeBuiltFrom(int[] candidateFreqs, int[] availableFreqs) {
        for (int i = 0; i < 10; i++) {
            if (candidateFreqs[i] > availableFreqs[i]) {
                return false;
            }
        }
        return true;
    }

    int[] digitFreq(int i) {
        char[] candidateDigits = String.valueOf(i).toCharArray();
        int[] freqs = new int[10];
        for (var digit : candidateDigits) {
            freqs[Character.getNumericValue(digit)] += 1;
        }
        return freqs;
    }
}
