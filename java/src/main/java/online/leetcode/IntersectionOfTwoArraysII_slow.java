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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII_slow {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> freq1 = count(nums1);
            Map<Integer, Integer> freq2 = count(nums2);

            return getIntersection(freq1, freq2);
        }

        private Map<Integer, Integer> count(int[] arr){
            Map<Integer, Integer> freq = new HashMap<>();
            Arrays.stream(arr).forEach(element->freq.put(element, freq.getOrDefault(element, 0)+1));
            return freq;
        }

        private int[] getIntersection(Map<Integer, Integer> freq1, Map<Integer, Integer> freq2){
            List<Integer> intersection = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry: freq1.entrySet()){
                int element = entry.getKey();
                int count1 = entry.getValue();
                int count2 = freq2.getOrDefault(element, 0);
                int count = Math.min(count1, count2);
                for (int i=0;i<count;++i){
                    intersection.add(element);
                }
            }

            return intersection.stream().mapToInt(i->i).toArray();
        }
    }
}
