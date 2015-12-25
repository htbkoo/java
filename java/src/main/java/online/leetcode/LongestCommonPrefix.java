package online.leetcode;

/**
 * Created by Hey on 25/12/15
 */

/*

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

Subscribe to see which companies asked this question

*/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder lcpSB = new StringBuilder();
        String lcp = "";

        if (strs.length == 0) {
            return "";
        }

        char[] sample = strs[0].toCharArray();

        for (char c : sample) {
            lcpSB = lcpSB.append(c);
            String tempLcp = lcpSB.toString();
            for (String str : strs) {
                if (!str.startsWith(tempLcp))
                    return lcp;
            }
            lcp = tempLcp;
        }

        return lcp;
    }
}
