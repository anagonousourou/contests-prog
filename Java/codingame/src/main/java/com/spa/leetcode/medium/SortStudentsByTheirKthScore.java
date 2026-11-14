package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class SortStudentsByTheirKthScore {

    //https://leetcode.com/problems/sort-the-students-by-their-kth-score/submissions/1162836132/
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparingInt(a -> -a[k]));
        return score;
    }
}
