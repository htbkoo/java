package online.leetcode;

/**
 * Created by Hey on 6/11/15
 */

/*

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Subscribe to see which companies asked this question

*/

public class FindMinimumInRotatedSortedArrayII {
//    LOL, never expected that O(n) naive approach would have same worst case complexity for part II
    public int findMin(int[] nums) {
        if (nums.length<=0){
            return 0;
        }
        int min = nums[0];
        for (int i : nums) {
//                Slight optimize
            if (i < min) {
                min = i;
                break;
            }

//                First O(n)
//                min = Math.min(i, min);
        }
        return min;
    }
}
