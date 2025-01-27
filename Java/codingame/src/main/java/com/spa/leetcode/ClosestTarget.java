package com.spa.leetcode;

public class ClosestTarget {

    // https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/submissions/1415626762/
    public int closetTarget(String[] words, String target, int startIndex) {
        // go right
        int rightDistance = -1;
        int count = 0;
        for (int i = startIndex; count < words.length; i = (i + 1) % words.length) {
            if (words[i].equals(target)) {
                rightDistance = count;
                break;
            } else {
                count++;
            }
        }

        // go left
        int leftDistance = -1;
        count = 0;
        for (int i = startIndex; count < words.length; i = (i - 1 + words.length) % words.length) {
            if (words[i].equals(target)) {
                leftDistance = count;
                break;
            } else {
                count++;
            }
        }

        if (leftDistance == -1 || rightDistance == -1) {
            return rightDistance == -1 ? leftDistance : rightDistance;
        }

        return Math.min(rightDistance, leftDistance);
    }
}
