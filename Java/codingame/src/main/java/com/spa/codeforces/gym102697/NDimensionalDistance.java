package com.spa.codeforces.gym102697;

import java.util.Arrays;
import java.util.Scanner;

public class NDimensionalDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow((in.nextInt() - in.nextInt()),2);
        }
        System.out.println(Math.sqrt(sum));

        in.close();
    }
}
