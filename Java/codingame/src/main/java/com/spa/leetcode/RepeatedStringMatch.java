package com.spa.leetcode;

public class RepeatedStringMatch {

    //https://leetcode.com/problems/repeated-string-match/
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder();
        int i = 0;
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            i++;
        }
        if (repeatedA.indexOf(b) != -1) {
            return i;
        }
        repeatedA.append(a);
        i++;
        if (repeatedA.indexOf(b) != -1) {
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        var matcher = new RepeatedStringMatch();
        String b = "bbaaaabbbbaabaaaabbbbaabaaaabbbbaabaaaabbbbaabaaaabbbbabbaaaabbbbabbaaaabbbbabbaaaabbbbabbaaaabbbbaa";
        String a = "baaaabbbba";

        System.out.println("Result " + matcher.repeatedStringMatch(a, b));
    }
}
