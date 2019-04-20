package online.leetcode;

/**
 * Created by Hey on 29/10/15
 */

/*

https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Subscribe to see which companies asked this question

*/

public class BinarySearch_recursive {
    static class Solution {
        private static final int NOT_EXIST = -1;

        public int search(int[] nums, int target) {
            int length = nums.length;
            if (length == 0) {
                return NOT_EXIST;
            } else {
                int lo = 0, hi = length - 1;
                return binarySearch(nums, target, lo, hi);
            }
        }

        private int binarySearch(int[] nums, int target, int lo, int hi) {
            if (lo <= hi) {
                int mid = (lo + hi) / 2;
                int midValue = nums[mid];
                if (target == midValue) {
                    return mid;
                } else if (target < midValue) {
                    return binarySearch(nums, target, lo, mid - 1);
                } else {
                    return binarySearch(nums, target, mid + 1, hi);
                }
            } else {
                return NOT_EXIST;
            }
        }
    }
}
