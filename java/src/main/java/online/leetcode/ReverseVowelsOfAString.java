package online.leetcode;

/**
 * Created by Hey on 28/4/16
 */

/*

https://leetcode.com/problems/reverse-vowels-of-a-string/

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Subscribe to see which companies asked this question

*/

public class ReverseVowelsOfAString {
//    5ms
    public String reverseVowels(String s) {
        final char[] chars = s.toCharArray();
        final int length = s.length();
        final char[] reversed = new char[length];
        int lindex = 0;
        int rindex = length - 1;
        while (rindex>=lindex) {
            final char lChar = chars[lindex];
            if (!isVowel(lChar)){
                reversed[lindex]=lChar;
                ++lindex;
            }else{
                char rChar = chars[rindex];
                while ((rindex>=lindex)&&(!isVowel(rChar))){
                    reversed[rindex]=rChar;
                    --rindex;
                    rChar = chars[rindex];
                }
                reversed[lindex]=rChar;
                ++lindex;
                reversed[rindex]=lChar;
                --rindex;
            }
        }

        return new String(reversed);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }
}
