package online.leetcode;

/**
 * Created by Hey on 25/10/15
 */

/*

https://leetcode.com/problems/excel-sheet-column-number/

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int number = 0;
        int digit = 1;
        final char[] title = new StringBuilder(s).reverse().toString().toCharArray();
        for (char c : title) {
            number += (c - 64) * digit;
            digit *= 26;
        }
        return number;
    }
}
