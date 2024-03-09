package com.spa.leetcode;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


//https://leetcode.com/problems/goal-parser-interpretation/
public class GoalParserInterpretation {

    private static final Pattern re = Pattern.compile("G|\\(\\)|\\(al\\)");

    public String interpret(String command) {

        StringBuilder tokens = new StringBuilder();
        Matcher m = re.matcher(command);

        while (m.find()) {
            tokens.append(transform(m.group()));
        }
        return tokens.toString();
    }

    private String transform(String t) {
        return switch (t) {
            case "G" -> "G";
            case "()" -> "o";
            case "(al)" -> "al";
            default -> t;
        };
    }
}
