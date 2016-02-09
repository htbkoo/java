package online.leetcode;

/**
 * Created by Hey on 9/2/16
 */

/*

https://leetcode.com/problems/search-insert-position/

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Subscribe to see which companies asked this question

*/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        final int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int low = 0;
        int high = length - 1;

        int mid = (int) ((long) (low + high) / 2);

        while ((mid != low) && (mid != high)) {
            final int num = nums[mid];
            if (target == num) {
                return mid;
            } else if (target < num) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (int) ((long) (low + high) / 2);
//            mid = (low + high) / 2;
        }

        if (target <= nums[low]) {
            return low;
        } else if (target <= nums[high]) {
            return high;
        } else {
            return high + 1;
        }
    }
}
