package com.spa.codeforces.gym102697;

import java.util.Scanner;

public class Polygons {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTests = in.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int nSides = in.nextInt();
            System.out.println((nSides - 3) * 180 + 180);
        }

        in.close();
    }
}
