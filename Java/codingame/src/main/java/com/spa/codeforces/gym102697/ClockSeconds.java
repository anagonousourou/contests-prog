package com.spa.codeforces.gym102697;

import java.util.Scanner;

public class ClockSeconds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        String period = in.nextLine();
        System.out.println(calculate(h, m, s, period));
        in.close();
    }

    static int calculate(int h, int m, int s, String period) {
        int sum = 0;

        sum += s;
        sum += m * 60;
        sum += h * 3600;
        if ("PM".equalsIgnoreCase(period.strip())) {
            sum += 12 * 3600;
        }
        return sum;
    }
}
