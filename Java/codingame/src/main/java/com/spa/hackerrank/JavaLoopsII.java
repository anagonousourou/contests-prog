package com.spa.hackerrank;

import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaLoopsII {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            String result = IntStream.iterate(a + b, new IntUnaryOperator() {
                int p = -1;

                @Override
                public int applyAsInt(int operand) {
                    p = p + 1;
                    return operand + (2 << p) * b;
                }
            }).limit(n).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(result);
        }
        in.close();
    }
}
