package online.leetcode;

/*

https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII_less_less_slow {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            Map<Integer, Integer> freq1 = count(nums1);

            return getIntersection(freq1, nums2);
        }

        private Map<Integer, Integer> count(int[] arr) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int element : arr) {
                freq.put(element, freq.getOrDefault(element, 0) + 1);
            }
            return freq;
        }

        private int[] getIntersection(Map<Integer, Integer> freq1, int[] nums2) {
            List<Integer> intersection = new ArrayList<>();
            for (int n : nums2) {
                if (freq1.containsKey(n) && freq1.get(n) > 0) {
                    intersection.add(n);
                    freq1.put(n, freq1.get(n) - 1);
                }
            }
            int length = intersection.size();
            int[] answer = new int[length];
            for (int i = 0; i < length; ++i) {
                answer[i] = intersection.get(i);
            }
            return answer;
        }
    }
}
