package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HardestWorker {


    // https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/submissions/1444667041/
    record Task(int workerId, int timeSpent) {

    }

    public int hardestWorker(int n, int[][] logs) {
        List<Task> tasks = new ArrayList<>(logs.length);
        for (int i = 0; i < logs.length; i++) {
            if (i == 0) {
                tasks.add(new Task(logs[i][0], logs[i][1]));
            } else {
                tasks.add(new Task(logs[i][0], logs[i][1] - logs[i - 1][1]));
            }
        }

        return tasks.stream().max(Comparator.comparingInt(Task::timeSpent)
            .thenComparingInt(task -> -task.workerId)).orElseThrow().workerId;
    }
}
