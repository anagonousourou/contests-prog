package com.spa.leetcode;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfGoodPairs {

    //https://leetcode.com/problems/number-of-good-pairs/
    public static int numIdenticalPairs(int[] nums) {
        var frequencies = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int result = 0;
        for (var count : frequencies.entrySet()) {
            if (count.getValue() > 1) {
                result += count.getValue() * (count.getValue() - 1) / 2;
                //this is the original formula based on combination https://calculis.net/combinaison
                //the above formula is the simplified one
                //result += (factorialUsingForLoop(count.getValue()).divide(factorialUsingForLoop(count.getValue() - 2).multiply(BigInteger.valueOf(2)))).intValue();
            }
        }
        return result;
    }

    public static BigInteger factorialUsingForLoop(long n) {
        BigInteger fact = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {
        numIdenticalPairs(new int[]{2, 2, 1, 5, 1, 5, 5, 2, 3, 1, 1, 5, 3, 2, 3, 3, 3, 1, 3, 3, 4, 3, 1, 3, 1, 4, 5, 5, 2, 2, 1, 3, 5, 2, 2, 4, 3, 2, 5, 3, 1, 1, 3, 3, 2, 5, 2, 1, 2, 4, 3, 4, 4, 3, 2, 4, 4, 1, 3, 3, 3, 5, 5, 5, 4, 1, 1, 2, 3, 3, 2, 5, 3, 4, 5, 3, 1, 2, 5, 4, 5, 2, 3, 3, 1, 5, 2, 4, 2, 4, 4, 3, 1, 3});

        System.out.println("n! "+ factorialUsingForLoop(27));
    }
}
