package com.spa.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        System.out.println(a.isProbablePrime(100) ? "prime": "not prime");
        scanner.close();
    }
}
