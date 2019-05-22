package online.leetcode;

/*

https://leetcode.com/problems/3sum/

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> solutionSet = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (isNotDuplicate(nums, i)) {
                    int lo = i + 1, hi = n - 1;
                    int target = -nums[i];
                    while (lo < hi) {
                        int value = nums[lo] + nums[hi];
                        if (value == target) {
                            solutionSet.add(Arrays.asList(nums[lo], nums[i], nums[hi]));
                            lo++;
                            hi--;
                            while (lo < hi && nums[lo] == nums[lo - 1]) {
                                lo++;
                            }
                            while (lo < hi && nums[hi] == nums[hi + 1]) {
                                hi--;
                            }
                        } else if (value < target) {
                            lo++;
                            while (lo < hi && nums[lo] == nums[lo - 1]) {
                                lo++;
                            }
                        } else {
                            hi--;
                            while (lo < hi && nums[hi] == nums[hi + 1]) {
                                hi--;
                            }
                        }
                    }
                }
            }

            return solutionSet;
        }

        private boolean isNotDuplicate(int[] nums, int i) {
            return (i == 0) || (nums[i] != nums[i - 1]);
        }
    }
}
