package com.spa.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SentenceSimilarityIII {

    // https://leetcode.com/problems/sentence-similarity-iii/submissions/1414735887/?envType=daily-question&envId=2024-10-06
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> words1 = new LinkedList<>(Arrays.asList(sentence1.split("\\s+")));
        Deque<String> words2 = new LinkedList<>(Arrays.asList(sentence2.split("\\s+")));

        while (!words1.isEmpty() && !words2.isEmpty() && words1.peekFirst().equals(words2.peekFirst())) {
            words2.removeFirst();
            words1.removeFirst();
        }

        while (!words1.isEmpty() && !words2.isEmpty() && words1.peekLast().equals(words2.peekLast())) {
            words2.removeLast();
            words1.removeLast();
        }

        return words2.isEmpty() || words1.isEmpty();

    }
}
