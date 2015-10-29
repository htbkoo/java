package online.leetcode;

/**
 * Created by Hey on 29/10/15
 */

/*

https://leetcode.com/problems/add-two-numbers/

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        int firstUnit = l1.val + l2.val + carry;
        if (firstUnit >= 10) {
            firstUnit %= 10;
            carry = 1;
        } else {
            carry = 0;
        }

        ListNode pointer = new ListNode(firstUnit);
        ListNode resultHead = pointer;

        while ((l1.next != null) || (l2.next != null)) {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }

            int unit = l1.val + l2.val + carry;
            if (unit >= 10) {
                unit %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            pointer.next = new ListNode(unit);
            pointer = pointer.next;
        }

        if (carry == 1) {
            pointer.next = new ListNode(1);
        }

        return resultHead;
    }
}
