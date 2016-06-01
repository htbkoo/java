package online.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Hey on 31/5/16
 */

/*

https://leetcode.com/problems/intersection-of-two-arrays/

 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.

Subscribe to see which companies asked this question

*/

public class IntersectionOfTwoArrays {

//    3ms
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        final int length1 = nums1.length, length2 = nums2.length;
        if (length1 == 0 || length2 == 0) {
            return new int[]{};
        }
        int i = 0, size = 0;
        int[] answer = new int[length1 + length2];

        Outer:
        for (int second : nums2) {
            int first = nums1[i];
            while (first < second) {
                if (i >= length1 - 1) {
                    break Outer;
                }
                first = nums1[++i];
            }
            if (first == second) {
                if (size > 0) {
                    if (answer[size - 1] == first) {
                        continue;
                    }
                }
                answer[size++] = first;
            }
        }
        return Arrays.copyOf(answer, size);
    }

//    117ms
    private class SlightlyFasterButUglierApproach {
        // (should be slightly) faster approach
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = arrayToSet(nums1);
            Set<Integer> set2 = arrayToSet(nums2);
            set1.retainAll(set2);

            int[] answer = new int[set1.size()];
            int i = 0;
            for (int n : set1) {
                answer[i++] = n;
            }
            return answer;
        }

        private Set<Integer> arrayToSet(int[] nums) {
            return Arrays.stream(nums).boxed().collect(Collectors.toSet());
        }
    }

//    120ms
    private class Java8StreamApiCleanerApproach {

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = arrayToSet(nums1);
            Set<Integer> set2 = arrayToSet(nums2);
            set1.retainAll(set2);

            return set1.stream().mapToInt(Number::intValue).toArray();
        }

        private Set<Integer> arrayToSet(int[] nums) {
            return Arrays.stream(nums).boxed().collect(Collectors.toSet());
        }
    }

}
