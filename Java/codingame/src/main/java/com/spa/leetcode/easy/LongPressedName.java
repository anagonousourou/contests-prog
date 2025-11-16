package com.spa.leetcode.easy;

public class LongPressedName {

    // https://leetcode.com/problems/long-pressed-name/submissions/1619124427/
    public boolean isLongPressedName(String name, String typed) {
        int nameIdx = 0;
        int typedIdx = 0;

        while (nameIdx < name.length()) {
            char tmp = name.charAt(nameIdx);
            int countName = 0;
            while (nameIdx < name.length() && tmp == name.charAt(nameIdx)) {
                nameIdx++;
                countName++;
            }

            int countTyped = 0;
            while (typedIdx < typed.length() && tmp == typed.charAt(typedIdx)) {
                typedIdx++;
                countTyped++;
            }
            if (countName > countTyped) {
                return false;
            }
        }

        return typedIdx >= typed.length();
    }
}
