package online.leetcode;

/**
 * Created by Hey on 28/10/15
 */

/*

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Subscribe to see which companies asked this question

*/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        final int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int low = 0;
        int high = length - 1;
        if (nums[low]<nums[high]){
//            unrotated, first element is minium
            return nums[low];
        }

        int mid = (high - low) / 2;
        while(high-low>1){
            if (nums[low]<nums[mid]){
                low = mid;
            }else{
                high = mid;
            }
            mid = (high + low) / 2;
        }

        return nums[high];

    }

    private class NaiveApproach {
        public int findMin(int[] nums) {
            int min = nums[1];
            for (int i : nums) {
//                Slight optimize
                if (i < min) {
                    min = i;
                    break;
                }

//                First O(n)
//                min = Math.min(i, min);
            }
            return min;
        }
    }

    private class FailedApproach {
        public int findMin(int[] nums) {
            final int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            if (length == 2) {
                return Math.min(nums[0], nums[1]);
            }

            int current = length / 2;

//            while (true) {
                if (Math.abs(length - current) <= 1) {
                    return getMinAmongNeighbours(nums, current);
                }
                if (current <= 1) {
                    return getMinAmongNeighbours(nums, current);
                }

                final int prev = nums[current - 1];
                final int self = nums[current];
                final int next = nums[current + 1];
//                if (prev < self) {
//                    if (self < prev) ;
//                } else {
//                    return self;
//                }

//                if (deltaIsPositive(nums, current)) {
//                    break;
//                }

//            }
            return getMinAmongNeighbours(nums, current);

        }

        private int getMinAmongNeighbours(int[] nums, int current) {
            return Math.min(Math.min(nums[current], nums[current - 1]), nums[current + 1]);
        }

        private boolean deltaIsPositive(int[] nums, int current) {
            return false;
        }
    }
}
