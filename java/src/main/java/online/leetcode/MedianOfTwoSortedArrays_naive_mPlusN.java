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

public class MedianOfTwoSortedArrays_naive_mPlusN {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] combined = combine(nums1, nums2);

            return findMedian(combined);
        }

        private int[] combine(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[] combined = new int[m + n];

            int i = 0, j = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    combined[i + j] = nums1[i];
                    i++;
                } else {
                    combined[i + j] = nums2[j];
                    j++;
                }
            }
            while (i < m) {
                combined[i + j] = nums1[i];
                i++;
            }
            while (j < n) {
                combined[i + j] = nums2[j];
                j++;
            }

            return combined;
        }

        private double findMedian(int[] arr) {
            int length = arr.length;
            boolean isOdd = length % 2 != 0;
            if (isOdd) {
                int middle = (length / 2);
                return arr[middle];
            } else {
                int first = length / 2 - 1;
                int second = length / 2;
                return ((double) (arr[first] + arr[second])) / 2d;
            }
        }
    }
}
