package com.spa.isograd;

import java.util.Scanner;

public class CombatMagique {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String magicSequence = sc.nextLine();
        String[] incantations = sc.nextLine().split(" ");

        for (String word : incantations) {
            if (word.contains(magicSequence)) {
                System.out.print(word + " ");
            } else {
                System.out.print(reverseString(word) + " ");
            }
        }
        System.out.println();
        sc.close();
    }

    private static String reverseString(String word) {
        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(word);

        // reverse StringBuilder input1
        input1.reverse();

        // print reversed String
        return input1.toString();
    }
}
