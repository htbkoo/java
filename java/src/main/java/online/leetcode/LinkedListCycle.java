package online.leetcode;

/**
 * Created by Hey on 24/1/16
 */

/*

https://leetcode.com/problems/linked-list-cycle/

Given a linked list, determine if it has a cycle in it.

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

public class LinkedListCycle {
    // Floyd's cycle-finding algorithm
    // https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null){
            fast = fast.next;
            if (fast==null){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
