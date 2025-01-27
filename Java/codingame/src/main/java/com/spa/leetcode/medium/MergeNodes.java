package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

public class MergeNodes {

    // https://leetcode.com/problems/merge-nodes-in-between-zeros/submissions/1421269783/
    public ListNode mergeNodes(ListNode head) {
        ListNode currentAcc = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val == 0 && current.next != null) {
                currentAcc.next = current;
                currentAcc = current;
                current = current.next;
            } else if (current.val == 0 && current.next == null) {
                currentAcc.next = null;
                break;
            } else {
                currentAcc.val += current.val;
                current = current.next;
            }

        }
        return head;
    }
}
