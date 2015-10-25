package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/contains-duplicate-ii/

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

*/

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final HashSet<Integer> set = new HashSet<>();
        final Deque<Integer> queue = new ArrayDeque<>();

        for (final int value : nums) {
            if (queue.size()>k){
                final Integer frontValue = queue.poll();
                set.remove(frontValue);
            }
            if (set.contains(value)) {
                return true;
            }
            queue.add(value);
            set.add(value);
        }
        return false;
    }
}
