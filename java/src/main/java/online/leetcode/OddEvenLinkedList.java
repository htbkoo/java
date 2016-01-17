package online.leetcode;

/**
 * Created by Hey on 17/1/16
 */

/*

https://leetcode.com/problems/odd-even-linked-list/

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...

Credits:
Special thanks to @aadarshjajodia for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

import online.leetcode.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        final ListNode evenFirst = head.next;
        ListNode current = evenFirst;
        ListNode oddLast = head;

        while (current != null) {
            if (current.next == null) {
                break;
            }
            ListNode evenNext = current.next.next;
            oddLast.next = current.next;
            oddLast.next.next = evenFirst;
            current.next = evenNext;
            current = evenNext;
            oddLast = oddLast.next;
        }
        return head;
    }
}
