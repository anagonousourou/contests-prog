package com.spa.leetcode;

import java.util.Arrays;

public class FindNumbersWithEvenNumberOfDigits {

    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/1200393625/
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).mapToObj(String::valueOf).filter(n -> n.length() % 2 == 0).count();
    }

    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/1200398100/
    public int findNumbersV2(int[] nums) {
        return (int) Arrays.stream(nums).filter(n -> n == 0 || ((int)Math.log10(n) + 1) % 2 == 0).count();
    }
}
