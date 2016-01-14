package online.leetcode;

import online.leetcode.util.ListNode;

/**
 * Created by Hey on 21/12/15
 */
/*

https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        final ListNode newHead = head.next;
        if (newHead == null) {
            return head;
        }

        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
