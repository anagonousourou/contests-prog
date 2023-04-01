package com.spa.codewars;

import com.spa.commonfns.StringHelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Runes {

    public static int solveExpression(final String expression) {
        int missingDigit = -1;

        //Write code to determine the missing digit or unknown rune
        //Expression will always be in the form
        //(number)[opperator](number)=(number)
        //Unknown digit will not be the same as any other digits used in expression

        Map<String, String> expressionMap = parseExpression(expression);
        List<String> possibleValues = possibleValues(expression, expressionMap);

        for (String possibleValue : possibleValues) {
            int op1 = Integer.parseInt(expressionMap.get("OPERAND1").replace("?", possibleValue));
            int op2 = Integer.parseInt(expressionMap.get("OPERAND2").replace("?", possibleValue));
            String operator = expressionMap.get("OPERATOR");
            int result = Integer.parseInt(expressionMap.get("RESULT").replace("?", possibleValue));

            switch(operator) {
                case "+":
                    if (op1 + op2 == result) {
                        return Integer.parseInt(possibleValue);
                    }
                    break;
                case "-":
                    if (op1 - op2 == result) {
                        return Integer.parseInt(possibleValue);
                    }
                    break;
                case "*":
                    if (op1 * op2 == result) {
                        return Integer.parseInt(possibleValue);
                    }
                    break;
            }

        }
        return missingDigit;
    }

    public static Map<String, String> parseExpression(final String expression) {
        Map<String, String> expressionMap = new HashMap<>(4);
        int i = 0;
        int j = 1;
        while (!Set.of('-', '+', '*').contains(expression.charAt(j))) {
            j++;
        }
        expressionMap.put("OPERAND1", expression.substring(i, j));
        expressionMap.put("OPERATOR", expression.substring(j, j + 1));
        i = j + 1;
        j = i + 1;
        while (!Objects.equals('=', expression.charAt(j))) {
            j++;
        }
        expressionMap.put("OPERAND2", expression.substring(i, j));

        expressionMap.put("RESULT", expression.substring(j + 1));
        return expressionMap;
    }

    public static List<String> possibleValues(final String expression, Map<String, String> expressionMap) {
        List<String> candidates = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        boolean cantBeZero = expressionMap.values().stream().anyMatch((String op) ->
            op.replace("-", ""). indexOf('?') == 0 && op.replace("-", "").length() > 1
        );

        if (cantBeZero) {
            candidates.remove("0");
        }

        Set<String> knowsDigits = new HashSet<>(StringHelpers.reSeq(Pattern.compile("\\d"), expression));
        candidates.removeAll(knowsDigits);
        return candidates;
    }
}
