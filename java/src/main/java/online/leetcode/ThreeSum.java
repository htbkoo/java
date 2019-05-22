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

            List<List<Integer>> solutionSet = new ArrayList<>();

            int n = nums.length;
            int l = 0, r=n-1;

            while ((r-l)>1){
                boolean isFound;
                do{
                    isFound = tryPair(nums, l, r, solutionSet);
                    r = getNextR(nums, r);
                }while((r-l)>1);

                //if (nums[nextL]!=nums[nextR]){
                //  tryPair(nums, l, nextR, solutionSet);
                //}

                l = getNextL(nums, l);
                r = n-1;
            }

            return solutionSet;
        }

        private boolean tryPair(int[] nums, int l, int r, List<List<Integer>> solutionSet){
            if ((r-l)>1){
                int targetValue = -(nums[l]+nums[r]);
                int index = Arrays.binarySearch(nums, l+1, r, targetValue);
                boolean isFound = index>=0;
                if (isFound){
                    solutionSet.add(Arrays.asList(nums[l], nums[index], nums[r]));
                    return true;
                }
            }
            return false;
        }

        private int getNextL(int[] nums, int l){
            int n = nums.length;
            while (l<n-1){
                if (nums[l]!=nums[l+1]){
                    return l+1;
                }else{
                    l++;
                }
            }
            return n-1;
        }

        private int getNextR(int[] nums, int r){
            while (r>0){
                if (nums[r]!=nums[r-1]){
                    return r-1;
                }else{
                    r--;
                }
            }
            return 0;

        }
    }
}
