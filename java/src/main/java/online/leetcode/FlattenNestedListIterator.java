package online.leetcode;

/**
 * Created by Hey on 21/4/16
 */

/*

https://leetcode.com/problems/flatten-nested-list-iterator/

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

Subscribe to see which companies asked this question

*/

import online.leetcode.util.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class FlattenNestedListIterator {
//    7ms
    public class NestedIterator implements Iterator<Integer> {

        private final List<Integer> list;
        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            flatten(nestedList);
            iterator = list.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void flatten(List<NestedInteger> nestedList) {
            for (NestedInteger n : nestedList) {
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    flatten(n.getList());
                }
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
