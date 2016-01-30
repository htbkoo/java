package online.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Hey on 17/1/16
 */

/*
https://leetcode.com/problems/min-stack/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Subscribe to see which companies asked this question

*/

class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private List<Integer> sortedList = new ArrayList<>();

    public void push(int x) {
        stack.push(x);
        addToSortedList(x);
    }

    public void pop() {
        sortedList.remove(findIndexByBinarySearch(top(), 0, sortedList.size() - 1));
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return sortedList.get(0);
    }

    private void addToSortedList(int x) {
        if (sortedList.size() == 0) {
            sortedList.add(x);
            return;
        }

        if (x < getMin()) {
            sortedList.add(0, x);
            return;
        }

        int index = findIndexByBinarySearch(x, 0, sortedList.size() - 1);
        sortedList.add(index, x);
    }

    private int findIndexByBinarySearch(int x, int low, int high) {
        int mid = (low + high) / 2;

        final int midValue = sortedList.get(mid);
        if (x == midValue) {
            return mid;
        } else {
            if ((mid == low) || (mid == high)) {
                if (x == sortedList.get(low)) {
                    return low;
                }
                if (x == sortedList.get(high)) {
                    return high;
                }
                if (x < sortedList.get(low)) {
                    return low;
                }
                if (x < sortedList.get(high)) {
                    return high;
                }
                return high + 1;
            }
            if (x < midValue) {
                return findIndexByBinarySearch(x, low, mid);
            }
        }
        return findIndexByBinarySearch(x, mid, high);
    }

    private class FailedApproachDueToTle {
        //        used 280ms for failed test case
        private Deque<Integer> stack = new ArrayDeque<>();
        private List<Integer> sortedList = new ArrayList<>();

        public void push(int x) {
            stack.push(x);
            addToSortedList(x);
        }

        public void pop() {
            sortedList.remove(Integer.valueOf(top()));
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return sortedList.get(0);
        }

        private void addToSortedList(int x) {
            if (sortedList.size() == 0) {
                sortedList.add(x);
                return;
            }

            if (x < getMin()) {
                sortedList.add(0, x);
                return;
            }

            if (sortedList.size() == 1) {
                sortedList.add(x);
            }

            int index = binarySearchForIndex(x, 1, sortedList.size() - 1);
            sortedList.add(index, x);
        }

        private int binarySearchForIndex(int x, int low, int high) {
            int mid = (low + high) / 2;

            if ((mid == low) || (mid == high)) {
                if (x < sortedList.get(low)) {
                    return low;
                }
                if (x < sortedList.get(high)) {
                    return high;
                }
                return high + 1;
            }

            final int midValue = sortedList.get(mid);
            if (x == midValue) {
                return mid;
            } else if (x < midValue) {
                return binarySearchForIndex(x, low, mid);
            }
            return binarySearchForIndex(x, mid, high);
        }
    }

//----------------------------------------------
//    SPOILER SOLUTION - START
//----------------------------------------------
/*
Hints:

Consider space-time tradeoff. How would you keep track of the minimums using extra space?
Make sure to consider duplicate elements.

O(n) runtime, O(n) space – Extra stack:

Use an extra stack to keep track of the current minimum value. During the push operation we choose the new element or the current minimum, whichever that is smaller to push onto the min stack.
O(n) runtime, O(n) space – Minor space optimization:

If a new element is larger than the current minimum, we do not need to push it on to the min stack. When we perform the pop operation, check if the popped element is the same as the current minimum. If it is, pop it off the min stack too.

*/
//----------------------------------------------
//    SPOILER SOLUTION - END
//----------------------------------------------

}
