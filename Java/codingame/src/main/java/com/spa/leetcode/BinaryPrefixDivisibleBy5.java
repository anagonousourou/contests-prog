package com.spa.leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>(nums.length);

        BigInteger prefixValue = BigInteger.ZERO;
        for (int num : nums) {
            prefixValue = prefixValue.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(num));
            result.add(prefixValue.remainder(BigInteger.valueOf(5)).equals(BigInteger.valueOf(5)));
        }
        return result;
    }
}
