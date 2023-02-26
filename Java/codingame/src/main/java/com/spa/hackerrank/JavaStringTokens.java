package com.spa.hackerrank;

import java.security.Permission;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Add {
    public void add(int... args) {
        int s = 0;
        for (int arg : args) {
            s += arg;
        }
        System.out.println(Arrays.stream(args).mapToObj(String::valueOf).collect(Collectors.joining("+")) + "=" + s);
    }
}

public class JavaStringTokens {

    public static void main(String[] args) {

    }
}

