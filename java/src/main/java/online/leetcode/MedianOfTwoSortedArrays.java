package online.leetcode;

/*

https://leetcode.com/problems/median-of-two-sorted-arrays/

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

public class MedianOfTwoSortedArrays {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;

            if (m == 0) {
                return median(nums2);
            } else if (n == 0) {
                return median(nums1);
            }

            if (nums1[m - 1] <= nums2[0]) {
                return median(nums1);
            } else if (nums2[n - 1] <= nums1[0]) {
                return median(nums1);
            } else {
                return 0d;
            }
        }

        private double median(int[] arr) {
            int length = arr.length;
            boolean isOdd = length % 2 == 1;
            if (isOdd) {
                return Double.valueOf(arr[length / 2]);
            } else {
                return (Double.valueOf(arr[length / 2]) + Double.valueOf(arr[length / 2 - 1])) / 2d;
            }
        }
    }
}
