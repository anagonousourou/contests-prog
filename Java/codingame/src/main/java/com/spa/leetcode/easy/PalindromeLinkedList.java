package com.spa.leetcode.easy;

import com.spa.leetcode.ListNode;

public class PalindromeLinkedList {

    // https://leetcode.com/problems/palindrome-linked-list/submissions/828784979/

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode reverseHead = new ListNode(head.val);
        while (current.next != null) {
            current = current.next;
            ListNode newHead = new ListNode(current.val);
            newHead.next = reverseHead;
            reverseHead = newHead;
        }

        while (head.next != null) {
            if (head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }
}
