package com.spa.leetcode;

public class CountDigits {

    //https://leetcode.com/problems/count-the-digits-that-divide-a-number/
    public int countDigits(int num) {
        return (int) String.valueOf(num).chars().mapToObj(c -> (char)c).map(Character::getNumericValue)
            .filter(n -> num % n == 0).count();
    }
}
