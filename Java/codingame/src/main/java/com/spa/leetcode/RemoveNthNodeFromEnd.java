package com.spa.leetcode;

public class RemoveNthNodeFromEnd {

    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/1192574224/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = len(head);
        if(size - n == 0){
            return head.next;
        }
        int i = 0;
        ListNode prev = head;
        ListNode current = head;
        while (i < size - n){
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
