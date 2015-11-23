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

public class RemoveNthNodeFromEndOfList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toBeRemoved = head;
        ListNode cur = head;
        while (n > 1) {
            cur = cur.next;
            --n;
        }
        ListNode last = null;
        while (cur.next != null) {
            cur = cur.next;
            last = toBeRemoved;
            toBeRemoved = toBeRemoved.next;
        }
        if (last==null){
            return head.next;
        }else{
            last.next = toBeRemoved.next;
            return head;
        }
    }
}
