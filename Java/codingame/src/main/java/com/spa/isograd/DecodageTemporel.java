package com.spa.isograd;

import java.util.*;

public class DecodageTemporel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        var lines1 = sc.nextLine().split(" ");
        var lines2 = sc.nextLine().split(" ");
        String line = sc.nextLine();
        Map<String, Set<String>> matches1 = new HashMap<>();
        Map<String, Set<String>> matches2 = new HashMap<>();
        getPossibleMatches(lines1[0], lines1[1], matches1);
        getPossibleMatches(lines2[0], lines2[1], matches2);

        System.out.println(getCode(line, intersectMatches(matches1, matches2)));
        /* Lisez les données et effectuez votre traitement */

    }

    private static String getCode(String sequence, Map<String, String> dictionnary) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < sequence.length(); index++) {
            builder.append(dictionnary.get(sequence.substring(index, index + 1)));
        }
        return builder.toString();
    }

    private static Map<String, String> intersectMatches(Map<String, Set<String>> matches1,
                                                        Map<String, Set<String>> matches2) {
        Map<String, String> matchesIntersection = new HashMap<>();

        matches1.forEach((key, value) -> {
            value.retainAll(matches2.get(key));
            System.out.println(value);
            matchesIntersection.put(key, value.stream().findAny().get());
        });

        return matchesIntersection;
    }

    private static void getPossibleMatches(String digitSequence, String codeSequence,
                                           Map<String, Set<String>> digitMatches) {
        if (digitSequence.isBlank()) {
            return;
        }
        String currentDigit = digitSequence.substring(0, 1);
        if (digitMatches.containsKey(currentDigit)) {
            if (codeSequence.length() > 2) {
                digitMatches.get(currentDigit).add(codeSequence.substring(0, 3));
            }
            if (codeSequence.length() > 3) {
                digitMatches.get(currentDigit).add(codeSequence.substring(0, 4));
            }

        } else {
            digitMatches.put(currentDigit, new HashSet<>());
            if (codeSequence.length() > 2) {
                digitMatches.get(currentDigit).add(codeSequence.substring(0, 3));
            }

            if (codeSequence.length() > 3) {
                digitMatches.get(currentDigit).add(codeSequence.substring(0, 4));
            }

        }
        if (codeSequence.length() > 2) {
            getPossibleMatches(digitSequence.substring(1), codeSequence.substring(3), digitMatches);
        }
        if (codeSequence.length() > 3) {
            getPossibleMatches(digitSequence.substring(1), codeSequence.substring(4), digitMatches);
        }

    }
}
