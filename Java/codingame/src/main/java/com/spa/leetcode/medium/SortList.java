package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        ListNode current = head;
        while (current != null){
            ListNode minPrev = current;
            ListNode latestMin = current;
            ListNode tmp = latestMin.next;
            while (tmp != null){
                if(tmp.val < latestMin.val){
                    latestMin = tmp;
                }
                tmp = tmp.next;
            }
            tmp = current.next;
            current.next = latestMin;
            current = tmp;

        }
        return null;
    }
}
