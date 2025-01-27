package com.spa.leetcode.easy;

public class ConvertDateToBinary {

    // https://leetcode.com/problems/convert-date-to-binary/submissions/1426207946/
    public String convertDateToBinary(String date) {
        var parts = date.split("-");
        return "%s-%s-%s".formatted(Integer.toBinaryString(Integer.parseInt(parts[0])), Integer.toBinaryString(Integer.parseInt(parts[1])), Integer.toBinaryString(Integer.parseInt(parts[2])));
    }
}
