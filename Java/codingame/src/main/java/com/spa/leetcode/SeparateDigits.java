package com.spa.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SeparateDigits {

    //https://leetcode.com/problems/separate-the-digits-in-an-array/submissions/1175006323/
    public int[] separateDigits(int[] nums) {
        return Arrays.stream(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining())
            .split("")).mapToInt(Integer::parseInt).toArray();
    }
}
