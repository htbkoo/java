package online.leetcode;

/**
 * Created by Hey on 7/12/15
 */

/*

https://leetcode.com/problems/merge-sorted-array/

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Subscribe to see which companies asked this question

*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);
        int nums1Cur = n;
        int nums2Cur = 0;
        int cur = 0;
        while ((nums1Cur < (m + n)) && (nums2Cur < n)) {
            if (nums1[nums1Cur] <= nums2[nums2Cur]) {
                nums1[cur] = nums1[nums1Cur];
                ++nums1Cur;
            } else {
                nums1[cur] = nums2[nums2Cur];
                ++nums2Cur;
            }
            ++cur;
        }
        while (nums1Cur < (m + n)) {
            nums1[cur] = nums1[nums1Cur];
            ++nums1Cur;
            ++cur;
        }
        while (nums2Cur < n) {
            nums1[cur] = nums2[nums2Cur];
            ++nums2Cur;
            ++cur;
        }
    }
}
