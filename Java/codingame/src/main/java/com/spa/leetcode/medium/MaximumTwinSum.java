package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSum {

    // https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/submissions/1421813798/
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();
        for (var i = head; i != null; i = i.next) {
            values.add(i.val);
        }

        int maximum = 0;
        for (int i = 0; i <= (values.size() / 2) - 1; i++) {
            maximum = Math.max(maximum, values.get(i) + values.get(values.size() - 1 - i));
        }
        return maximum;
    }
}
