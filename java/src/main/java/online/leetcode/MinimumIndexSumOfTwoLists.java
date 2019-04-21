package online.leetcode;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> fav1 = toMap(list1);
            Map<String, Integer> fav2 = toMap(list2);

            List<String> mins = new ArrayList<>();
            int minSum = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : fav1.entrySet()) {
                String key = entry.getKey();
                if (fav2.containsKey(key)) {
                    Integer index1 = entry.getValue();
                    Integer index2 = fav2.get(key);
                    int sum = index1 + index2;
                    if (sum == minSum) {
                        mins.add(key);
                    } else if (sum < minSum) {
                        minSum = sum;
                        mins = new ArrayList<>();
                        mins.add(key);
                    }
                }
            }

            return mins.toArray(new String[0]);
        }

        private Map<String, Integer> toMap(String[] list) {
            Map<String, Integer> fav1 = new HashMap<>();
            for (int i = 0, length = list.length; i < length; ++i) {
                fav1.put(list[i], i);
            }
            return fav1;
        }
    }
}
