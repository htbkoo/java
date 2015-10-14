package online.leetcode;

import java.util.HashSet;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/single-number/

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class SingleNumber {
    public int singleNumber(int[] nums) {
//        According to assumption, appears TWICE -> no 3 times, so can use set
        final HashSet<Integer> set = new HashSet<>();

        for (final int value : nums) {
            final boolean valueInSet = set.contains(value);
            if (!valueInSet) {
                set.add(value);
            } else {
                set.remove(value);
            }
        }

        return set.iterator().next();
    }
}
