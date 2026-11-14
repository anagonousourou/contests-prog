package com.spa.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumNumberOfTasksYouCanAssign {

    // https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/submissions/1623062100/

    private int[] tasks;
    private int[] workers;
    private int strength;
    private int pills;
    private int taskCount;
    private int workerCount;

    // The main function for finding the maximum number of tasks that can be assigned.
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        this.strength = strength;
        this.pills = pills;
        taskCount = tasks.length; // Total number of tasks
        workerCount = workers.length; // Total number of workers

        // Binary search to find the maximum number of tasks
        int left = 0, right = Math.min(workerCount, taskCount);
        while (left < right) {
            int mid = (left + right + 1) / 2; // Mid-point of the search
            if (check(mid)) {
                left = mid; // If mid is possible, search further to the right
            } else {
                right = mid - 1; // Otherwise, search to the left
            }
        }

        return left; // The maximum number of tasks that can be assigned
    }

    // A helper function that checks whether x number of tasks can be assigned to the workers.
    private boolean check(int x) {
        int taskIdx = 0;
        Deque<Integer> taskQueue = new ArrayDeque<>();
        int remainingPills = pills;

        // Iterating over the sorted workers and tasks to determine if the tasks 
        // can be assigned with the constraints of strength and pills.
        for (int workerIdx = workerCount - x; workerIdx < workerCount; ++workerIdx) {
            while (taskIdx < x && tasks[taskIdx] <= workers[workerIdx] + strength) {
                taskQueue.offer(tasks[taskIdx++]); // Add valid tasks to queue
            }
            if (taskQueue.isEmpty()) {
                return false; // No tasks available to assign
            }
            if (taskQueue.peekFirst() <= workers[workerIdx]) {
                taskQueue.pollFirst(); // Assign tasks within current worker capabilities
            } else if (remainingPills == 0) {
                return false; // No pills remaining to boost the worker's strength
            } else {
                --remainingPills; // Use a pill and assign the most difficult task
                taskQueue.pollLast();
            }
        }
      
        return true; // Every worker is assigned a task successfully
    }
}
