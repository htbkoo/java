package online.leetcode;

/**
 * Created by Hey on 13/11/15
 */

/*

https://leetcode.com/problems/majority-element/

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int current = nums[0];
        int times = 0;
        for (int num : nums) {
            if (num == current) {
                times++;
            } else {
                if (times <= 0) {
                    current = num;
                } else {
                    times--;
                }
            }
        }
        return current;
    }
}
