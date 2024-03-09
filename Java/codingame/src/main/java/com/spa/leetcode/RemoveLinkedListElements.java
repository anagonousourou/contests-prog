package com.spa.leetcode;

public class RemoveLinkedListElements {


    //https://leetcode.com/problems/remove-linked-list-elements/submissions/1180904344/
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.val == val){
            return removeElements(head.next, val);
        }else{
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
