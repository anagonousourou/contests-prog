package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

public class LinkedListCycleIi {

    // https://leetcode.com/problems/linked-list-cycle-ii/submissions/831938301/

       public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        boolean cyclic = false;
        while (hare != null) {
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                hare = null;
            }

            tortoise = tortoise.next;

            if (tortoise == hare) {
                cyclic = true;
                break;
            }

        }

        if (cyclic) {
            tortoise = head;
            while (tortoise != hare && hare != null) {
                hare = hare.next;
                tortoise = tortoise.next;
            }
            return hare;
        }
        return null;
    }
}
