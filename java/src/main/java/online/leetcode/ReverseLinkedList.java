package online.leetcode;

import online.leetcode.util.ListNode;

/**
 * Created by Hey on 14/11/15
 */
/*

https://leetcode.com/problems/reverse-linked-list/

Reverse a singly linked list.

click to show more hints.

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

public class ReverseLinkedList {
//    First attempt is recursive approach
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode newhead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }

    private class ReverseLinkedListRecursively {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            } else if (head.next == null) {
                return head;
            } else {
                ListNode newhead = reverseList(head.next);
                head.next.next = head;
                head.next = null;
                return newhead;
            }
        }
    }

    private class ReverseLinkedListIteratively {
        public ListNode reverseList(ListNode head) {
            ListNode last = null;
            ListNode current = head;
            while (current!= null){
                ListNode next = current.next;
                current.next = last;
                last = current;
                current = next;
            }

            return last;
        }
    }
}
