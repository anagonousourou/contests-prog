package com.spa.leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycle {


    //https://en.wikipedia.org/wiki/Cycle_detection
    //https://leetcode.com/problems/linked-list-cycle/
    //with hare & tortoise algorithm
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while (hare != null) {
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                hare = null;
            }

            tortoise = tortoise.next;

            if (tortoise == hare && hare != null) {
                return true;
            }
        }
        return false;
    }


    /**
     * With obvious solution O(n) memory
     *
     * @param head
     * @return
     */
    public boolean hasCycleV1(ListNode head) {
        Set<ListNode> encountered = new HashSet<>();
        ListNode current = head;
        while (current != null && !encountered.contains(current)) {
            encountered.add(current);
            current = current.next;
        }
        return current != null;
    }
}
