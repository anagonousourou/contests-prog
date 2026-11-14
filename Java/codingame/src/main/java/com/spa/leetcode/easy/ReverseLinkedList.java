package com.spa.leetcode.easy;

import com.spa.leetcode.ListNode;

public class ReverseLinkedList {

    // https://leetcode.com/problems/reverse-linked-list/submissions/1122540701/

    public ListNode reverseList(ListNode head) {
        // 1 -> 7 -> 3 ->
        // <-1 , 7 -> 3 ->
        // <- 1 <- 7, 3 ->

        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode resultHead) {
        // 1 -> 7 -> 3 ->
        // <-1 , 7 -> 3 ->
        // <- 1 <- 7, 3 ->

        if (head == null) {
            return resultHead;
        }

        if (resultHead == null) {
            ListNode newInitialHead = head.next;
            head.next = null;
            return reverseList(newInitialHead, head);
        }

        ListNode newInitialHead = head.next;
        head.next = resultHead;
        return reverseList(newInitialHead, head);
    }
}
