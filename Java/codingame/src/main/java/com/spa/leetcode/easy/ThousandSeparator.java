package com.spa.leetcode.easy;

import java.util.LinkedList;

public class ThousandSeparator {

    // https://leetcode.com/problems/thousand-separator/submissions/1430268029/
    public String thousandSeparator(int n) {
        String nstr = String.valueOf(n);

        LinkedList<String> blocks = new LinkedList<>();

        for (int i = nstr.length(); i >= 0; i = i - 3) {
            var newblock = nstr.substring(Math.max(i - 3, 0), i);
            if (!newblock.isBlank()) {
                blocks.addFirst(newblock);
            }
        }

        return String.join(".", blocks);
    }
}
