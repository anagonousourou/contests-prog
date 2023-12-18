package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

public class StringsGCD {
    public String gcdOfStrings(String str1, String str2) {
        int maxLength = Math.min(str2.length(), str1.length());
        String smallerStr = str1.length() > str2.length() ? str2 : str1;
        for (int i = maxLength; i > 0; i--) {
            if (str2.length() % i == 0 && str1.length() % i == 0) {
                var gcdOpt = StringHelpers.slices(smallerStr, i).stream()
                    .filter(candidate -> candidate.repeat(str2.length() / candidate.length()).equals(str2)
                        && candidate.repeat(str1.length() / candidate.length()).equals(str1))
                    .findFirst();
                if (gcdOpt.isPresent()) {
                    return gcdOpt.get();
                }
            }

        }
        return "";
    }

    public static void main(String[] args) {
        var component = new StringsGCD();
        System.out.println(component.gcdOfStrings("ABABAB", "ABAB"));
    }
}
