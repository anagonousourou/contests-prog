package com.spa.codeforces.gym102697;

import java.util.Scanner;

//https://codeforces.com/gym/102697
public class TriangleSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTriangles = in.nextInt();
        int sum = 0;
        for (int i = 0; i < numberOfTriangles; i++) {
            sum += in.nextInt() * 3;
        }
        System.out.println(sum);

        in.close();
    }
}
