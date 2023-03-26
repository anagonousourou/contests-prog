package com.spa.hackerrank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat numberFormatUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat numberFormatFR = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String china = NumberFormat.getCurrencyInstance(new Locale("zh", "CN")).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        System.out.println("US: " + numberFormatUS.format(payment));
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + numberFormatFR.format(payment));
    }
}

