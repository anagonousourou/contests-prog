package com.spa.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LexicographicalNumbers {

    // https://leetcode.com/problems/lexicographical-numbers/
    // I don't think it is the expected solution, but it passes the checks
    public List<Integer> lexicalOrder(int n) {
        return IntStream.rangeClosed(1, n).boxed().sorted(Comparator.comparing(String::valueOf)).toList();
    }
}
