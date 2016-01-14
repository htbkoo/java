package online.leetcode;

import online.leetcode.util.ListNode;

/**
 * Created by Hey on 22/12/15
 */
/*

https://leetcode.com/problems/rotate-list/

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        ListNode cur = head;
        if (cur == null) {
//            return head; // head is always null
            return null;
        }

        int length = 1;

        ListNode prev = null;

        while (cur.next != null) {
            length++;
            prev = cur;
            cur = cur.next;
        }

        if (prev == null) {
            return head;
        }

        k %= length;
        if (k == 0) {
            return head;
        }

        k = length - k; // Without this, it is rotate-left

        ListNode tail = head;
        for (int i = 1; i < k; ++i) {
            tail = tail.next;
        }

        ListNode start = tail.next;
        cur.next = head;
        tail.next = null;

        return start;
    }
}
