package com.spa.leetcode.easy;

import com.spa.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/1134993167/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
