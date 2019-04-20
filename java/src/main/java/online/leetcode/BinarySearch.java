package online.leetcode;

import java.util.Arrays;

/**
 * Created by Hey on 29/10/15
 */

/*

https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Subscribe to see which companies asked this question

*/

public class BinarySearch {
    static class Solution {
        public int search(int[] nums, int target) {
            int index = Arrays.binarySearch(nums, target);
            return index >= 0 ? index : -1;
        }
    }
}
