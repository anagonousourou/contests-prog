package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class EvaluateReversePolishNotation {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    //https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=daily-question&envId=2024-01-30
    public static int evalRPN(String[] tokens) {
        Deque<String> tokensStack = new LinkedList<>();
        Deque<String> deStack = new LinkedList<>();
        for (var token : tokens) {
            tokensStack.push(token);
        }

        while (tokensStack.size() > 1) {
            String token1 = tokensStack.pop();
            String token2 = tokensStack.pop();
            String token3 = tokensStack.pop();
            deStack.push(token1);
            deStack.push(token2);
            deStack.push(token3);
            while (!(OPERATORS.contains(token1) && !OPERATORS.contains(token2) && !OPERATORS.contains(token3))) {
                token1 = token2;
                token2 = token3;
                token3 = tokensStack.pop();
                deStack.push(token3);
            }
            String result = evaluate(token1, token2, token3);
            tokensStack.push(result);
            deStack.pop();
            deStack.pop();
            deStack.pop();

            while (!deStack.isEmpty()) {
                tokensStack.push(deStack.pop());
            }

        }

        return Integer.parseInt(tokensStack.pop());
    }


    private static String evaluate(String operator, String operand1, String operand2) {
        return switch (operator) {
            case "+" -> String.valueOf(Integer.parseInt(operand1) + Integer.parseInt(operand2));
            case "-" -> String.valueOf(Integer.parseInt(operand2) - Integer.parseInt(operand1));
            case "*" -> String.valueOf(Integer.parseInt(operand1) * Integer.parseInt(operand2));
            case "/" -> String.valueOf(Integer.parseInt(operand2) / Integer.parseInt(operand1));
            default -> "";
        };
    }


    public static void main(String[] args) {
        System.out.println("Result 9 == " + evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println("Result 6 == " + evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println("Result 22 == " + evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
