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

    //    4ms
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ((headA == null) || (headB == null)) {
            return null;
        }
        final int aLength = listLength(headA);
        final int bLength = listLength(headB);

        ListNode tailA = reverseList(headA);

        ListNode ptrB = headB;

        int length = 1;
        while (ptrB.next != null) {
            ptrB = ptrB.next;
            ++length;
        }
        reverseList(tailA);

        if (ptrB != headA) {
            return null;
        }

        final int intersectionPos = bLength - (aLength + bLength - 1 - length) / 2;

        ListNode intersection = headB;
        for (int i = 1; i < intersectionPos; ++i) {
            intersection = intersection.next;
        }

        return intersection;
    }

    private int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
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

            reverseList(tailB);
            reverseList(tailA);
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

//----------------------------------------------
//    SPOILER SOLUTION - START
//----------------------------------------------
/*

https://leetcode.com/problems/intersection-of-two-linked-lists/solution/

Intersection of Two Linked Lists

There are many solutions to this problem:

    Brute-force solution (O(mn) running time, O(1) memory):

    For each node ai in list A, traverse the entire list B and check if any node in list B coincides with ai.
    Hashset solution (O(n+m) running time, O(n) or O(m) memory):

    Traverse list A and store the address / reference to each node in a hash set. Then check every node bi in list B: if bi appears in the hash set, then bi is the intersection node.
    Two pointer solution (O(n+m) running time, O(1) memory):
        Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
        When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
        If at any point pA meets pB, then pA/pB is the intersection node.
        To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
        If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.

Analysis written by @stellari.

Average Rating: 4.5 (528 votes)

Is this solution helpful? Read our book to learn more.*/

//----------------------------------------------
//    SPOILER SOLUTION - END
//----------------------------------------------

}
