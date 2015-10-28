package online.leetcode;

/**
 * Created by Hey on 25/10/15
 */

/*

https://leetcode.com/problems/excel-sheet-column-title/

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.

*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 26) {
            stringBuilder = stringBuilder.append((char) (((n - 1) % 26) + 1 + 64));
            n = (n - 1) / 26;
        }
        return stringBuilder.append((char) (n + 64)).reverse().toString();
    }
}
