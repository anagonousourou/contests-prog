package com.spa.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddingBigNumbers {

    /**
     * Add two positive (big) integers represented as string
     * In this exercise we cannot use BigInteger
     * @param a first integer
     * @param b second integer
     * @return the sum of a and b
     */
    public static String add(String a, String b) {
        if("0".equals(a) && a.equals(b)){
            return a;
        }
        int maxLength = Math.max(b.length(), a.length()) + 1;
        byte[] result = add(convert(a, maxLength), convert(b, maxLength));
        return IntStream.range(0, result.length).map(idx -> result[idx]).dropWhile(i -> i == 0).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    static byte[] convert(String s, int length) {
        byte[] result = new byte[length];
        Arrays.fill(result, (byte) 0);
        int j = length - 1;
        for (int i = s.length() - 1; i >= 0; i--, j--) {
            result[j] = (byte) Character.getNumericValue(s.charAt(i));
        }
        return result;
    }

    static byte[] add(byte[] a, byte[] b) {
        int maxLength = b.length;
        byte[] result = new byte[maxLength];
        Arrays.fill(result, (byte) 0);
        int remainder = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            result[i] = (byte) ((a[i] + b[i] + remainder) % 10);
            remainder = (a[i] + b[i] + remainder) / 10;
        }
        return result;
    }


}
