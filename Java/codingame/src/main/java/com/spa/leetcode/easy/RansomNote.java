package com.spa.leetcode.easy;

import java.util.Arrays;

public class RansomNote {

    // https://leetcode.com/problems/ransom-note/submissions/827310520/

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCounts = new int[26];
        Arrays.fill(magazineCounts, 0);
        int[] ransomNoteCounts = new int[26];
        Arrays.fill(ransomNoteCounts, 0);

        int[] magazineAsInts = magazine.chars().map(c -> c - 97).toArray();
        int[] ransomNoteAsInts = ransomNote.chars().map(c -> c - 97).toArray();

        for (int magazineLetter : magazineAsInts) {
            magazineCounts[magazineLetter]++;
        }

        for (int ransomLetter : ransomNoteAsInts) {
            ransomNoteCounts[ransomLetter]++;
        }

        for (int i = 0; i < ransomNoteCounts.length; i++) {
            if (magazineCounts[i] < ransomNoteCounts[i]) {
                return false;
            }
        }

        return true;
    }
}
