package com.spa.leetcode.easy;

import com.spa.leetcode.ListNode;

public class MergeTwoSortedLists {

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/831366083/

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list2 == null && list1 != null){
            return list1;
        }
        
        return mergeTwoListsImpl(list1, list2, null, null);
    }

    public ListNode mergeTwoListsImpl(ListNode list1, ListNode list2, ListNode result, ListNode head) {
        if (list1 == null && list2 == null) {
            return head;
        }
        if (list1 == null) {
            result.next = list2;
            return head;
        }
        if (list2 == null) {
            result.next = list1;
            return head;
        }

        if (list1.val <= list2.val) {
            ListNode nextList1;
            if (head == null) {
                result = list1;
                nextList1 = list1.next;
                result.next = null;
                head = result;
            } else {
                result.next = list1;
                nextList1 = list1.next;
                result.next.next = null;
                result = result.next;
            }

            return mergeTwoListsImpl(nextList1, list2, result, head);
        } else {
            ListNode nextList2;
            if (result == null) {
                result = list2;
                nextList2 = list2.next;
                result.next = null;
                head = result;
            } else {
                result.next = list2;
                nextList2 = list2.next;
                result.next.next = null;
                result = result.next;
            }
            return mergeTwoListsImpl(list1, nextList2, result, head);
        }

    }
 
}
