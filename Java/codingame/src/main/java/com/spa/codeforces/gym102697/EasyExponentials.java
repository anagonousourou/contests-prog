package com.spa.codeforces.gym102697;

import java.util.Scanner;

public class EasyExponentials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int k = in.nextInt();
        System.out.println((long) Math.pow(n, k));
        in.close();
    }
}
