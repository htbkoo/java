package online.leetcode;

/*

https://leetcode.com/problems/container-with-most-water/

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.



The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

*/

public class ContainerWithMostWater_slow {
    static class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int max = Math.min(height[0], height[1]);
            for (int i=0;i<n;++i){
                for (int j=i+1;j<n;++j){
                    int width = j-i;
                    int h = Math.min(height[i], height[j]);
                    max = Math.max(max, width*h);
                }
            }
            return max;
        }
    }
}
