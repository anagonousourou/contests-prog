package com.spa.leetcode;

public class OddEvenLinkedList {

    //https://leetcode.com/problems/odd-even-linked-list
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;

        ListNode current = head;
        ListNode evenCurrent = evenHead;
        ListNode oddCurrent = head;
        while (current != null && current.next != null) {
            current = current.next.next;
            oddCurrent.next = current;
            if (current != null) {
                evenCurrent.next = current.next;
            }
            if (oddCurrent.next != null) {
                oddCurrent = oddCurrent.next;
            }
            if (evenCurrent.next != null) {
                evenCurrent = evenCurrent.next;
            }
        }
        oddCurrent.next = evenHead;

        return head;
    }
}
