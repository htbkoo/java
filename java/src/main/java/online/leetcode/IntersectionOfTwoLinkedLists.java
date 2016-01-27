package online.leetcode;

import online.leetcode.util.ListNode;

/**
 * Created by Hey on 27/1/16
 */

/*

https://leetcode.com/problems/intersection-of-two-linked-lists/

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

Credits:
Special thanks to @stellari for adding this problem and creating all test cases.

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

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    private class FailedAttempt {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if ((headA == null) || (headB == null)) {
                return null;
            }
            ListNode ptrA = headA;
            ListNode ptrB = headB;
            while (ptrA != null) {
                if (ptrB == ptrA) {
                    return ptrB;
                }
                ptrA = ptrA.next;
            }
            ptrA = headA;
            ptrB = headB;
            while (ptrB != null) {
                if (ptrA == ptrB) {
                    return ptrA;
                }
                ptrB = ptrB.next;
            }

            ListNode tailA = reverseList(headA);
            ListNode tailB = reverseList(headB);
            ListNode intersection = null;
            ptrA = tailA;
            ptrB = tailB;

//        A more correct behavoir - which there are NO tests cases to verify NOR ANYONE to ask
            while (ptrA == ptrB) {
                if ((ptrA == null)) {
                    break;
                }
                intersection = ptrA;
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }

//        do {
//            if ((ptrA == null)||(ptrB == null)) {
//                break;
//            }
//            if (ptrA.val!=ptrB.val){
//                break;
//            }
//            intersection = ptrA;
//            ptrA = ptrA.next;
//            ptrB = ptrB.next;
//        } while (true);

            reverseList(tailA);
            reverseList(tailB);
            return intersection;
        }

        private ListNode reverseList(ListNode head) {
            ListNode next;
            ListNode prev = null;
            while (head != null) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
