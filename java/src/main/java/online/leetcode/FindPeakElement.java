package online.leetcode;

/**
 * Created by Hey on 5/2/16
 */

/*

https://leetcode.com/problems/find-peak-element/

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:

Your solution should be in logarithmic complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        final int length = nums.length;
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        if (length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[length - 1] > nums[length - 2]) {
            return length - 1;
        }

        int low = 1;
        int high = length - 2;
        int mid = (int) (((long) high + (long) low) / 2L);
        while ((mid != low) && (mid != high)) {
            if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (int) (((long) high + (long) low) / 2L);
        }

        if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
            return mid;
        } else if (nums[mid + 1] > nums[mid]) {
            return mid + 1;
        } else {
            return mid - 1;
        }
    }

    private class MistakenlyReadQuestion {
        public int findPeakElement(int[] nums) {
            final int length = nums.length;
//        if (length == 0) {
//            return Integer.MIN_VALUE;
//        }
//        if (length == 1) {
//            Due to the fact that the test case is stupid: Input: [1] -> Expected: 0
//            return 0;
//            return nums[0];
//        }
//        if (nums[0] > nums[1]) {
//            return nums[0];
//        }
//        if (nums[length - 1] > nums[length - 2]) {
//            return nums[length - 1];
//        }
            if (length <= 2) {
                return 0;
            }

            int low = 1;
            int high = length - 2;
            int mid = (int) (((long) high + (long) low) / 2L);
            while ((mid != low) && (mid != high)) {
                if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                    return nums[mid];
                } else if (nums[mid + 1] > nums[mid]) {
                    low = mid;
                } else {
                    high = mid;
                }
                mid = (int) (((long) high + (long) low) / 2L);
            }

            if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                return nums[mid];
            } else if (nums[mid + 1] > nums[mid]) {
                return nums[mid + 1];
            } else {
                return nums[mid - 1];
            }
        }
    }
}
