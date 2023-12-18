package com.spa.leetcode;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int nb = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if (!isOrdered(i, strs)) {
                nb++;
            }
        }
        return nb;
    }

    public boolean isOrdered(int columnIndex, String[] strs) {
        for (int i = 0; i + 1 < strs.length; i++) {
            if (strs[i].charAt(columnIndex) > strs[i + 1].charAt(columnIndex)) {
                return false;
            }
        }
        return true;
    }
}
