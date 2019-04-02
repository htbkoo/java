package online.hackerrank.interviewPreparationKit.LinkedLists;

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
class Node {
int data;
Node next;
}
*/
public class LinkedListsDetectACycle {
    public static class Solution {
        boolean hasCycle(Node head) {
            if (head == null) {
                return false;
            } else {
                Node fast = head;
                Node slow = head;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
