package online.leetcode;

/**
 * Created by Hey on 17/11/15
 */

/*

https://leetcode.com/problems/reverse-linked-list-ii/

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

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

public class ReverseLinkedListII {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private boolean isNeedReverse(int nowCount, int m, int n) {
        return (m <= nowCount) && (nowCount <= n);
    }

    //    First attempt is iterative approach
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode last = null;
        ListNode next;
        ListNode current = head;
        while (current != null) {
            if (isNeedReverse(count, m, n)) {
                ListNode before = last;
                ListNode first = current;

                next = current.next;
                last = current;
                current = next;
                count++;
                while ((isNeedReverse(count, m, n) && (current != null))) {
                    next = current.next;
                    current.next = last;
                    last = current;
                    current = next;
                    count++;
                }
                first.next = current;
//                ((before == null) ? head : before.next) = last;
                if (before == null) {
                    head = last;
                } else {
                    before.next = last;
                }
                return head;
            }
            next = current.next;
            last = current;
            current = next;
            count++;
        }

        return head;
    }

    private class failedAttempt {
        //    First attempt is iterative approach
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) return head;

            ListNode last = null;
            ListNode current = head;
            int nowCount = 1;
            while (current != null) {
                ListNode next = current.next;
                if (isNeedReverse(nowCount, m, n)) {
                    ListNode beforeReverse = last;
                    ListNode firstToReverse = current;
                    last = current;
                    current = next;
                    while (isNeedReverse(nowCount, m, n) && (current != null)) {
                        next = current.next;
                        current.next = last;
                        last = current;
                        current = next;
                        nowCount++;
                    }
                    if (beforeReverse == null) {
                        head = last;
                    } else {
                        beforeReverse.next = last.next;
                    }
                    firstToReverse.next = current;

                    return head;
                }
                last = current;
                current = next;
                nowCount++;
            }

            return head;
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
            while (current != null) {
                ListNode next = current.next;
                current.next = last;
                last = current;
                current = next;
            }

            return last;
        }
    }
}
