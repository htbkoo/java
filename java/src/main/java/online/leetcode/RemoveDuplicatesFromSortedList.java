package online.leetcode;

/**
 * Created by Hey on 19/11/15
 */

/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Subscribe to see which companies asked this question

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class RemoveDuplicatesFromSortedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        if (current!=null) {
            ListNode next = current.next;
            while (next != null) {
                if (current.val==next.val){
                    next = next.next;
                    current.next = next;
                }else {
                    current = next;
                    next = next.next;
                }
            }
        }
        return head;
    }
}
