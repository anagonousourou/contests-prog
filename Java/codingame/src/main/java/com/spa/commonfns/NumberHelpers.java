package com.spa.commonfns;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberHelpers {

    /**
     * From
     * ephultman's
     * solution
     * https://exercism.org/profiles/ephultman
     */
    private static Predicate<List<Double>> legalTriangle = l -> {
        double sum = l.stream()
            .mapToDouble(Double::doubleValue)
            .sum();
        return l.stream()
            .allMatch(side ->
                (sum - side > side) && (side > 0));
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while (scanner.hasNextLine()) {
            short op = scanner.nextShort();
            int num = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.println(isOdd(num) ? "ODD" : "EVEN");
                    break;
                case 2:
                    System.out.println(isPrime(num) ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    System.out.println(isPalindrome(num) ? "PALINDROME" : "NOT PALINDROME");
                    break;
            }
        }
    }

    public static boolean isEven(int n){
        return n % 2 == 0;
    }

    public static boolean isOdd(int n){
        return n % 2 != 0;
    }

    public static boolean isPrime(long n){
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if( n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        return StringHelpers.isPalindrome(String.valueOf(n));
    }

    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }

    /**
     * Return all the primes in [2, maxPrime[
     *
     * @param maxPrime the limit
     * @return prime numbers
     */
    public static List<Integer> getPrimes(int maxPrime) {
        boolean[] sieve = new boolean[maxPrime];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < Math.sqrt(maxPrime); i++) {
            if (sieve[i]) {
                for (int j = i * i; j < maxPrime; j = j + i) {
                    sieve[j] = false;
                }
            }
        }
        return IntStream.range(2, maxPrime).filter(i -> sieve[i]).boxed().toList();
    }

    public static int computeSquareOfSumTo(int input) {
        int sum = ((1 + input) * input) / 2;
        return sum * sum;
    }

    public static boolean isTriangle(double side1, double side2, double side3) {
        if (Stream.of(side1, side2, side3).anyMatch(s -> s <= 0)) {
            return false;
        }
        return side1 <= side2 + side3 && side2 <= side1 + side3 && side3 <= side1 + side2;
    }

    /**
     * https://www.trans4mind.com/personal_development/mathematics/series/sumNaturalSquares.htm
     *
     * @param input
     * @return
     */
    public static int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * (2 * input + 1)) / 6;
    }

    public static int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

    /**
     * @param n a positive integer
     * @return the divisors of n
     */
    public static Set<Integer> getDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (n / i != n) {
                    divisors.add(n / i);
                }

            }
        }
        return divisors;
    }

    public static boolean isArmstrongNumber(int numberToCheck) {
        int numberOfDigits = String.valueOf(numberToCheck).length();
        return String.valueOf(numberToCheck).chars().map(Character::getNumericValue).mapToLong(i -> (long) Math.pow(i, numberOfDigits)).sum() == numberToCheck;
    }

}
