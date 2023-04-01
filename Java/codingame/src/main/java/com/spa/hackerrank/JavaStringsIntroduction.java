package com.spa.hackerrank;


import java.util.Scanner;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(a.length() + b.length());
        System.out.println(a.compareTo(b) >= 1 ? "Yes" : "No");
        System.out.printf("%s %s%n", a.substring(0, 1).toUpperCase() + a.substring(1), b.substring(0, 1).toUpperCase() + b.substring(1));
        scanner.close();
    }
}
