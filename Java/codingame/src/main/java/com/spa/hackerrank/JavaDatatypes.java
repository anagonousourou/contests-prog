package com.spa.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaDatatypes {
    public static void main(String[] argh) {


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            try {
                long x  = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (between(x, BigInteger.valueOf(Byte.MIN_VALUE), BigInteger.valueOf(Byte.MAX_VALUE))){
                    System.out.println("* byte");
                }
                if (between(x, BigInteger.valueOf(Short.MIN_VALUE), BigInteger.valueOf(Short.MAX_VALUE))){
                    System.out.println("* short");
                }
                if(between(x, BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.valueOf(Integer.MAX_VALUE))){
                    System.out.println("* int");
                }
                if (between(x, BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MAX_VALUE))){
                    System.out.println("* long");
                }
                //Complete the code
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }

    public static boolean between(long x, BigInteger a , BigInteger b){
        return a.compareTo(BigInteger.valueOf(x)) <= 0 &&  BigInteger.valueOf(x).compareTo(b) <=0;
    }
}
