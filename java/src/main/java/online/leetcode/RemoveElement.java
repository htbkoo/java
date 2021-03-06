package online.leetcode;

/**
 * Created by Hey on 29/11/15
 */

/*

https://leetcode.com/problems/remove-element/

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question

*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (nums[i] != val) {
                nums[length] = nums[i];
                ++length;
            }
        }
        return length;
    }
}
