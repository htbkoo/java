package online.leetcode;

/*

https://leetcode.com/problems/minesweeper/

Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

    If a mine ('M') is revealed, then the game is over - change it to 'X'.
    If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
    If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
    Return the board when no more squares will be revealed.



Example 1:

Input:

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:

Input:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:



Note:

    The range of the input matrix's height and width is [1,50].
    The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
    The input board won't be a stage when game is over (some mines have been revealed).
    For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.

*/

public class Minesweeper {
    static class Solution {
        private static class Board {
            private static final char[][] ZERO_SIZE_BOARD = new char[0][];
            private static final char MINE = 'M';
            private static final char REVEALED_MINE = 'X';
            private final char[][] board;

            Board(char[][] board) {
                this.board = board;
            }

            static Board fromCharMatrix(char[][] board) {
                return new Board(copyCharMatrix(board));
            }

            Board click(Coordinates coordinates) {
                char[][] newBoard = copyCharMatrix(board);

                if (isMine(newBoard, coordinates)) {
                    gameover(newBoard, coordinates);
                } else {
                    reveal(newBoard, coordinates);
                }

                return new Board(newBoard);
            }

            private boolean isMine(char[][] board, Coordinates coordinates) {
                return MINE == board[coordinates.row][coordinates.col];
            }

            private void gameover(char[][] board, Coordinates coordinates) {
                board[coordinates.row][coordinates.col] = REVEALED_MINE;
            }

            private void reveal(char[][] newBoard, Coordinates coordinates) {

            }

            char[][] asCharMatrix() {
                return copyCharMatrix(board);
            }

            private static char[][] copyCharMatrix(char[][] board) {
                int length = board.length;
                if (length == 0) {
                    return ZERO_SIZE_BOARD;
                } else {
                    char[][] newBoard = new char[length][];
                    for (int i = 0; i < length; ++i) {
//                        newBoard[i] = Arrays.copyOf(row, row.length);
                        newBoard[i] = board[i].clone();
                    }
                    return newBoard;
                }
            }
        }

        private static class Coordinates {
            final int row;
            final int col;

            Coordinates(int row, int col) {
                this.row = row;
                this.col = col;
            }

            static Coordinates fromArray(int[] click) {
                return new Coordinates(click[0], click[1]);
            }
        }

        public char[][] updateBoard(char[][] board, int[] click) {
            Board prevState = Board.fromCharMatrix(board);
            return prevState.click(Coordinates.fromArray(click)).asCharMatrix();
        }
    }
}
