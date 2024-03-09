package com.spa.hackerrank;

public class RecursiveDigitSum {

    public static int superDigit(String n, int k) {
       long digitsSum = n.chars().map(Character::getNumericValue).mapToLong(i -> (long)i).sum();
        return superDigit(digitsSum, k);
    }

    public static int superDigit(long n, int k) {
        if(n < 10 && k > 1){
            return superDigit(n * k, 1);
        }
        else if( n < 10 && k == 1){
            return (int) n;
        }
        return superDigit(String.valueOf(n).chars().map(Character::getNumericValue).mapToLong(i -> (long)i).sum(), k);
    }


}
