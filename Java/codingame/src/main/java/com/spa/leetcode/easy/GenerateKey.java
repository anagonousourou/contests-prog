package com.spa.leetcode.easy;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateKey {

    // https://leetcode.com/problems/find-the-key-of-the-numbers/submissions/1427272432/
    public int generateKey(int num1, int num2, int num3) {
        var ns = Stream.of(num1, num2, num3).map("%04d"::formatted).toList();

        String key = "";
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            key += ns.stream().mapToInt(n -> Character.getNumericValue(n.charAt(finalI))).min().orElseThrow();
        }
        return Integer.parseInt(key);
    }

}
