package online.leetcode;

import java.util.HashSet;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/contains-duplicate/

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

*/

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        final HashSet<Integer> set = new HashSet<>();

        for (final int value : nums) {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }

        return false;
    }
}
