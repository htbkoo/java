package online.leetcode;

/**
 * Created by Hey on 14/1/16
 */

/*

https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

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

public class PalindromeLinkedList {
//    follow up approach, faster
    public boolean isPalindrome(ListNode head) {
        final int length = getListLength(head);

        if (length <= 1) {
            return true;
        }

        if (length == 2) {
            return head.val == head.next.val;
        }

        ListNode tail = reverseListAndGetNewHeadFrom(head, (length + 1) / 2 + 1);

        final int compareTimes = length / 2;

        for (int i = 0; i < compareTimes; ++i) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    private ListNode reverseListAndGetNewHeadFrom(ListNode current, int from) {
        int oneBasedCurIs = 1;
        ListNode previous = current;
        ListNode next;
        while (current != null) {
            next = current.next;
            if (oneBasedCurIs > from) {
                current.next = previous;
            }
            previous = current;
            current = next;
            ++oneBasedCurIs;
        }
        return previous;
    }

    private int getListLength(ListNode current) {
        int length = 0;
        while (current != null) {
            ++length;
            current = current.next;
        }
        return length;
    }

    private class InfiniteMemoryUsageApproachEvenSlower {
        //    14ms
        public boolean isPalindrome(ListNode head) {
            final int ARRAY_SIZE = 1_048_576;
//        Already MLE
//        final int ARRAY_SIZE = 16_777_216;
            int[] vals = new int[ARRAY_SIZE];

            int length = 0;
            while (head != null) {
                vals[length] = head.val;
                ++length;
                head = head.next;
            }

            return isPalindrome(vals, length);
        }

        private boolean isPalindrome(int[] vals, int length) {

            if (length <= 1) {
                return true;
            }

            if (length == 2) {
                return vals[0] == vals[1];
            }

            final int compareTimes = length / 2;

            for (int i = 0; i < compareTimes; ++i) {
                if (vals[i] != vals[length - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }

    //    3ms
    private class FollowUpOnO1Approach {
        public boolean isPalindrome(ListNode head) {
            final int length = getListLength(head);

            if (length <= 1) {
                return true;
            }

            if (length == 2) {
                return head.val == head.next.val;
            }

            ListNode tail = reverseListAndGetNewHeadFrom(head, (length + 1) / 2 + 1);

            final int compareTimes = length / 2;

            for (int i = 0; i < compareTimes; ++i) {
                if (head.val != tail.val) {
                    return false;
                }
                head = head.next;
                tail = tail.next;
            }
            return true;
        }

        private ListNode reverseListAndGetNewHeadFrom(ListNode current, int from) {
            int oneBasedCurIs = 1;
            ListNode previous = current;
            ListNode next;
            while (current != null) {
                next = current.next;
                if (oneBasedCurIs > from) {
                    current.next = previous;
                }
                previous = current;
                current = next;
                ++oneBasedCurIs;
            }
            return previous;
        }

        private int getListLength(ListNode current) {
            int length = 0;
            while (current != null) {
                ++length;
                current = current.next;
            }
            return length;
        }
    }
}
