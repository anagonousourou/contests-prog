package com.spa.hackerrank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = a / b;
            System.out.println(c);

        } catch (RuntimeException runtimeException) {
            if (runtimeException instanceof InputMismatchException) {
                System.out.println(runtimeException.getClass().getCanonicalName());
            } else {
                System.out.println(runtimeException);
            }

        } finally {
            scanner.close();
        }

    }
}
