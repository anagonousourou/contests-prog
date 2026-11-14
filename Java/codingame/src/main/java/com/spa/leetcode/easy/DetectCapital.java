package com.spa.leetcode.easy;

public class DetectCapital {

    // https://leetcode.com/problems/detect-capital/submissions/869745268/

    public boolean detectCapitalUse(String word) {
        return word.chars().allMatch(Character::isLowerCase) ||
            word.chars().allMatch(Character::isUpperCase) ||
            (Character.isUpperCase(word.charAt(0)) &&
                word.chars().skip(1).allMatch(Character::isLowerCase));
    }
}
