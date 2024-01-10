package com.spa.leetcode;

public class RemoveDuplicatesFromSortedList {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null){
            if(current.next != null && current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}
