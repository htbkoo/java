package online.leetcode;

/**
 * Created by Hey on 20/11/15
 */

/*

https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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

public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergedList;

        if (l1.val <= l2.val) {
            mergedList = l1;
            l1 = l1.next;
        } else {
            mergedList = l2;
            l2 = l2.next;
        }
        ListNode current = mergedList;

        while ((l1 != null) && (l2 != null)) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }

        return mergedList;
    }
}
