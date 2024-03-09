package com.spa.leetcode;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        int size = len(head);
        if(size == 1){
            return head.next;
        }
        int i = 0;
        ListNode prev = head;
        ListNode current = head;
        while (i < size / 2){
            i++;
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        current.next = null;
        return head;
    }

    int len(ListNode head){
        if(head == null){
            return 0;
        }
        return 1 + len(head.next);
    }
}
