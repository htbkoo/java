package online.leetcode;

/**
 * Created by Hey on 5/2/16
 */

/*

https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.

Subscribe to see which companies asked this question

*/

public class ValidSudoku {
//    6ms
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; ++r) {
            boolean[] appearedRow = new boolean[10];
            boolean[] appearedCol = new boolean[10];
            for (int c = 0; c < 9; ++c) {
                if (isDigitDuplicated(board[c][r], appearedRow)) return false;
                if (isDigitDuplicated(board[r][c], appearedCol)) return false;
            }
        }

        for (int a = 0; a < 9; ++a) {
            boolean[] appearedArea = new boolean[10];
            for (int i = (a % 3) * 3; i < (a % 3) * 3 + 3; ++i) {
                for (int j = (a / 3) * 3; j < (a / 3) * 3 + 3; ++j) {
                    if (isDigitDuplicated(board[i][j], appearedArea)) return false;
                }
            }
        }

        return true;
    }

    private boolean isDigitDuplicated(char c, boolean[] appeared) {
        if (c != '.') {
            if (!appeared[(c - '0')]) {
                appeared[(c - '0')] = true;
            } else {
                return true;
            }
        }
        return false;
    }
}
