package com.spa.hackerrank;


import com.spa.commonfns.StringHelpers;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            System.out.println(StringHelpers.isPairedRecursive(line, new LinkedList<>()));
        }
        scanner.close();
    }
}
