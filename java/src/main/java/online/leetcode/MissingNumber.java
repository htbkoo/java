package online.leetcode;

import java.util.Arrays;

/**
 * Created by Hey on 11/12/15
 */

/*

https://leetcode.com/problems/missing-number/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class MissingNumber {
//    As of 11-Dec-2015, 1 ms in Leetcode 121 test cases
    public int missingNumber(int[] nums) {
        final int length = nums.length;
        final int shouldSum = (length) * (length + 1) / 2;
        int sum = 0;
//        Try using java 8 stream API
//        int sum = Arrays.stream(nums).sum();
        for (int num : nums) {
            sum += num;
        }

        return shouldSum - sum;
    }

    private class MissingNumberUsingStreamAPI {
        //        Very slow
        //    As of 11-Dec-2015, 83 ms in Leetcode 121 test cases
        public int missingNumber(int[] nums) {
            final int length = nums.length;
            final int shouldSum = (length) * (length + 1) / 2;

//        Try using java 8 stream API
            int sum = Arrays.stream(nums).sum();
//        for (int num:nums){
//            sum+=num;
//        }

            return shouldSum - sum;
        }
    }
}
