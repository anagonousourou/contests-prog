package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class NodesBetweenCriticalPoints {


    // https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/submissions/1484752233/
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPointsPositions = new ArrayList<>();
        ListNode prev = null;
        ListNode current = head;
        int i = 0;
        while (current.next != null) {
            if (prev != null && ((prev.val < current.val && current.val > current.next.val) || (prev.val > current.val && current.val < current.next.val))) {
                criticalPointsPositions.add(i);
            }
            i++;
            prev = current;
            current = current.next;
        }

        if (criticalPointsPositions.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDistance = criticalPointsPositions.getLast() - criticalPointsPositions.getFirst();
        for (int j = 0; j < criticalPointsPositions.size() - 1; j++) {
            minDistance = Math.min(minDistance, criticalPointsPositions.get(j + 1) - criticalPointsPositions.get(j));
        }

        return new int[]{minDistance, criticalPointsPositions.getLast() - criticalPointsPositions.getFirst()};
    }
}
