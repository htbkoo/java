package online.leetcode;

/**
 * Created by Hey on 20/11/15
 */

/*

https://leetcode.com/problems/merge-k-sorted-lists/

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Subscribe to see which companies asked this question

*/

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //    First attempt is Priority Queue approach
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue;
        if (lists.length <= 11) {
            priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        } else {
            priorityQueue = new PriorityQueue<>(lists.length, (o1, o2) -> Integer.compare(o1.val, o2.val));
        }

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        final ListNode mergedList = priorityQueue.poll();
        if (mergedList == null) {
            return null;
        }

        if (mergedList.next != null) {
            priorityQueue.add(mergedList.next);
        }
        ListNode current = mergedList;

        while (!priorityQueue.isEmpty()) {
            final ListNode smallest = priorityQueue.poll();
            current.next = smallest;
            if (smallest.next != null) {
                priorityQueue.add(smallest.next);
            }
            current = current.next;
        }

        return mergedList;
    }

    private class PriorityQueueApproach {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> priorityQueue;
            if (lists.length <= 11) {
                priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
            } else {
                priorityQueue = new PriorityQueue<>(lists.length, (o1, o2) -> Integer.compare(o1.val, o2.val));
            }

            for (ListNode node : lists) {
                if (node != null) {
                    priorityQueue.add(node);
                }
            }

            final ListNode mergedList = priorityQueue.poll();
            if (mergedList == null) {
                return null;
            }

            if (mergedList.next != null) {
                priorityQueue.add(mergedList.next);
            }
            ListNode current = mergedList;

            while (!priorityQueue.isEmpty()) {
                final ListNode smallest = priorityQueue.poll();
                current.next = smallest;
                if (smallest.next != null) {
                    priorityQueue.add(smallest.next);
                }
                current = current.next;
            }

            return mergedList;
        }
    }

    private class MergeSortApproach {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int first, int last) {
            if (last - first > 1) {
                final int middle = first + (last - first) / 2;
                final ListNode firstHalf = merge(lists, first, middle);
                final ListNode secondHalf = merge(lists, middle + 1, last);
                return mergeTwoLists(firstHalf, secondHalf);
            } else if (last - first == 1) {
                return mergeTwoLists(lists[first], lists[last]);
            } else if (first == last) {
                return lists[first];
            } else {
//                for empty lists
                return null;
            }
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
