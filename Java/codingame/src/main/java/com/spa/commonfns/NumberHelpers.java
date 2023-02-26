package com.spa.commonfns;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class NumberHelpers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while (scanner.hasNextLine()){
            short op = scanner.nextShort();
            int num = scanner.nextInt();
            switch (op){
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

    public static boolean isPalindrome(int n){
        return StringHelpers.isPalindrome(String.valueOf(n));
    }

    public static boolean isPowerOf2(int num){
        return (num & num - 1) == 0;
    }

}
