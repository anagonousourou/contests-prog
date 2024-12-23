package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

public class MergeInBetween {
    //https://leetcode.com/problems/merge-in-between-linked-lists/submissions/1485644024/
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null;
        ListNode current = list1;
        ListNode beforeA = null;
        ListNode afterB = null;
        int i = 0;

        while (i <= b){
            if(i == a){
                beforeA = prev;
            }
            if(i == b){
                afterB = current.next;
            }
            prev = current;
            current = current.next;
            i++;
        }

        ListNode endList2 = list2;

        while (endList2.next != null){
            endList2 = endList2.next;
        }

        beforeA.next = list2;
        endList2.next = afterB;



        return list1;
    }
}
