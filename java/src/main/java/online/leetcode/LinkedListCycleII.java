package online.leetcode;

/**
 * Created by Hey on 24/1/16
 */

/*

https://leetcode.com/problems/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

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

public class LinkedListCycleII {
    // Floyd's cycle-finding algorithm
    // https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare

    // And same idea as 287 - Find the Duplicate Number
    // http://keithschwarz.com/interesting/code/find-duplicate/FindDuplicate.python.html
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null){
            fast = fast.next;
            if (fast==null){
                return null;
            }
            fast=fast.next;
            slow=slow.next;
            if (slow==fast){
                while (head!=slow){
                    head=head.next;
                    slow=slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
