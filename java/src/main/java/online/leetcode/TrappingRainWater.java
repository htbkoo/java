package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Hey on 26/10/15
 */

/*

https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

*/

public class TrappingRainWater {
    private static class HeightWithPos {
        final private int height;
        private int lowest;
        final private int pos;

        private HeightWithPos(int height, int pos) {
            this.height = height;
            this.pos = pos;
            this.lowest = 0;
        }

        public int getHeight() {
            return height;
        }

        public int getPos() {
            return pos;
        }

        public int getLowest() {
            return lowest;
        }

        public void setLowest(int lowest) {
            this.lowest = lowest;
        }
    }

    public int trap(int[] height) {
        int water = 0;
        Deque<HeightWithPos> highests = new ArrayDeque<>();
        for (int i = 0; i < height.length; ++i) {
            while (!highests.isEmpty()) {
                final HeightWithPos heightWithPos = highests.pop();
                final int highest = heightWithPos.getHeight();
                final int width = i - heightWithPos.getPos() - 1;
                final int lowest = heightWithPos.getLowest();
                final int current = height[i];
                if (current >= highest) {
                    water += (highest - lowest) * width;
                } else {
                    water += (current - lowest) * width;
                    heightWithPos.setLowest(current);
                    highests.push(heightWithPos);
                    break;
                }
            }
            highests.push(new HeightWithPos(height[i], i));
        }
        return water;
    }
}
