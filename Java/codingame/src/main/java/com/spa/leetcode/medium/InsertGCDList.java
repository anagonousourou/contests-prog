package com.spa.leetcode.medium;

import com.spa.commonfns.NumberHelpers;
import com.spa.leetcode.ListNode;

public class InsertGCDList {


    // https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/submissions/1421255991/
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current.next = new ListNode(gcd(current.val, current.next.val), current.next);
            current = current.next.next;
        }
        return head;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
