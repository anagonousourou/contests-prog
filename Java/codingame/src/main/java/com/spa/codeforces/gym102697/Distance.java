package com.spa.codeforces.gym102697;

import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        System.out.println(Math.sqrt((x1 - x2) * (double) (x1 - x2) + (y1 - y2) * (y1 - y2)));

        in.close();
    }
}
