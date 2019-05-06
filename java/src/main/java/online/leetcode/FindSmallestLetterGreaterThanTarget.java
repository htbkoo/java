package online.leetcode;

/*

https://leetcode.com/problems/find-smallest-letter-greater-than-target/

 Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:

Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"

Note:

    letters has a length in range [2, 10000].
    letters consists of lowercase letters, and contains at least 2 unique letters.
    target is a lowercase letter.

*/

public class FindSmallestLetterGreaterThanTarget {
    static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int index = findIndex(letters, target);

            if (index >= letters.length) {
                return letters[0];
            } else {
                return letters[index];
            }
        }

        private int findIndex(char[] letters, char target) {
            int lo = 0, hi = letters.length - 1;

            int mid = (lo + hi) / 2;
            while (hi - lo > 1) {
                if (target >= letters[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
                mid = (lo + hi) / 2;
            }

            if (target < letters[lo]) {
                return lo;
            } else {
                if (target < letters[hi]) {
                    return hi;
                } else {
                    return hi + 1;
                }
            }
        }
    }
}
