package com.spa.leetcode;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        return word.chars().allMatch(Character::isLowerCase) ||
            word.chars().allMatch(Character::isUpperCase) ||
            (Character.isUpperCase(word.charAt(0)) &&
                word.chars().skip(1).allMatch(Character::isLowerCase));
    }
}
