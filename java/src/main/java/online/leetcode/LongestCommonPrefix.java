package online.leetcode;

import java.util.Arrays;

/**
 * Created by Hey on 25/12/15
 */

/*

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

Subscribe to see which companies asked this question

*/

public class LongestCommonPrefix {

//    2ms with pure char array manipulation
    public String longestCommonPrefix(String[] strs) {
        final int length = strs.length;
        if (length == 0) {
            return "";
        }

        char[][] chars = new char[length][];
        for (int i = 0; i < length; ++i) {
            chars[i] = strs[i].toCharArray();
        }

        char[] sample = chars[0];

        final int slength = sample.length;
        int j = 0;
        for (; j < slength; ++j) {
            char ch=sample[j];
            for (char[] chs: chars) {
                if ((j>=chs.length)||(ch!=chs[j])) {
                    return new String(Arrays.copyOf(sample, j));
                }
            }
        }

        return new String(Arrays.copyOf(sample, j));
    }

    private class FirstAttempt4ms {
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
}
