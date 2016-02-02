package online.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hey on 2/2/16
 */

/*

https://leetcode.com/problems/summary-ranges/

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> ranges = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            long diff = (long) i - (long) max;
            if (diff > 1) {
                if (min == max) {
                    ranges.add(String.valueOf(min));
                } else {
                    ranges.add(min + "->" + max);
                }
                min = i;
                max = i;
            } else if (diff == 1) {
                max = i;
            }
        }

        if (min == max) {
            ranges.add(String.valueOf(min));
        } else {
            ranges.add(min + "->" + max);
        }
        return ranges;
    }
}
