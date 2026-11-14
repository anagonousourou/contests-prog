package com.spa.leetcode.easy;

import com.spa.leetcode.ListNode;

public class MiddleOfTheLinkedList {

    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/1196673938/

    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int size = 0;
        do {
            size++;
            current = current.next;
        } while (current != null);
        int middle = size / 2;
        int i = 0;
        while (i < middle) {
            head = head.next;
            i++;
        }
        return head;
    }
}
