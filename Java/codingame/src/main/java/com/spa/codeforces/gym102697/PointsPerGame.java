package com.spa.codeforces.gym102697;

import java.util.Scanner;

public class PointsPerGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int points = in.nextInt();
        int games = in.nextInt();
        System.out.println((double) points / games);

        in.close();
    }
}
