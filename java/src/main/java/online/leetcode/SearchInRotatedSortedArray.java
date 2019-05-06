package online.leetcode;

/*

https://leetcode.com/problems/search-in-rotated-sorted-array/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/

public class SearchInRotatedSortedArray {
    static class Solution {
        private static final int NOT_FOUND = -1;

        public int search(int[] nums, int target) {
            int length = nums.length;
            if (length == 0) {
                return NOT_FOUND;
            } else if (length == 1) {
                return target == nums[0] ? 0 : NOT_FOUND;
            } else {
                int maxIndex = findMaxIndex(nums);
                int max = nums[maxIndex];
                if (target > max) {
                    return NOT_FOUND;
                } else if (target <= nums[length - 1]) {
                    return binarySearchIndex(nums, target, (maxIndex + 1) % length, length - 1);
                } else {
                    return binarySearchIndex(nums, target, 0, maxIndex);
                }
            }
        }

        private int findMaxIndex(int[] nums) {
            int last = nums.length - 1;
            if (nums[last] > nums[0]) {
                return last;
            } else {
                int lo = 0, hi = last;
                while (hi - lo > 1) {
                    int mid = (lo + hi) / 2;
                    if (nums[mid] > nums[lo]) {
                        lo = mid;
                    } else {
                        hi = mid - 1;
                    }
                }

                return nums[hi]>nums[lo]?hi:lo;
            }
        }

        private int binarySearchIndex(int[] nums, int target, int lo, int hi) {
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return NOT_FOUND;
        }
    }
}
