/*

https://leetcode.com/problems/minimum-index-sum-of-two-lists/

 Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:

    The length of both lists will be in the range of [1, 1000].
    The length of strings in both lists will be in the range of [1, 30].
    The index is starting from 0 to the list length minus 1.
    No duplicates in both lists.

*/

package online.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    static class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set = new HashSet<>();

            int xCur = 1, yCur = 1;
            int sum = xCur + yCur;
            while (sum <= bound) {
                while (sum <= bound) {
                    set.add(sum);
                    if (x == 1) {
                        break;
                    }
                    xCur *= x;
                    sum = xCur + yCur;
                }
                xCur = 1;

                if (y == 1) {
                    break;
                }
                yCur *= y;
                sum = xCur + yCur;
            }

            return new ArrayList<>(set);
        }
    }
}
