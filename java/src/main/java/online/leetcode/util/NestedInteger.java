package online.leetcode.util;

/**
 * Created by Hey on 21 Apr 2016.
 * <p>
 * ---
 * <p>
 * For LeetCode NestedInteger type
 */

import java.util.List;


public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    // public [sic]
    @SuppressWarnings("UnnecessaryInterfaceModifier")
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    // public [sic]
    @SuppressWarnings("UnnecessaryInterfaceModifier")
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    // public [sic]
    @SuppressWarnings("UnnecessaryInterfaceModifier")
    public List<NestedInteger> getList();
}