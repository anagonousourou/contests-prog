package com.spa.leetcode;

import java.util.List;
import java.util.stream.IntStream;

public class SelfDividingNumbers {

    //https://leetcode.com/problems/self-dividing-numbers/submissions/1234201757/
    public List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.rangeClosed(left,right).filter(i ->
            String.valueOf(i).chars().map(Character::getNumericValue).allMatch(digit -> digit != 0 && i % digit == 0)
        ).boxed().toList();
    }
}
