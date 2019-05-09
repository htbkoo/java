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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

import static java.util.stream.IntStream.range;

public class Minesweeper {
    static class Solution {
        private static class Square implements Cloneable {
            private static final char CHAR_MINE = 'M';
            private static final char CHAR_EMPTY = 'E';
            private static final char CHAR_BLANK = 'B';
            private static final char CHAR_REVEALED_MINE = 'X';

            static final Square MINE = new Square(CHAR_MINE);
            static final Square BLANK = new Square(CHAR_BLANK);
            static final Square EMPTY = new Square(CHAR_EMPTY);
            static final Square REVEALED_MINE = new Square(CHAR_REVEALED_MINE);
            final char value;

            private Square(char value) {
                this.value = value;
            }

            static Square fromNumAdjacentMines(int numAdjacentMines) {
                if (numAdjacentMines == 0) {
                    return BLANK;
                } else {
                    return new Square(Character.forDigit(numAdjacentMines, 10));
                }
            }

            boolean isMine() {
                return CHAR_MINE == value;
            }

            boolean isEmpty() {
                return CHAR_EMPTY == value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Square square = (Square) o;
                return value == square.value;
            }

            @Override
            public int hashCode() {
                return Objects.hash(value);
            }
        }

        private static class Board {
            private static final Square[][] ZERO_SIZE_BOARD = new Square[0][];
            private final Square[][] board;

            Board(Square[][] board) {
                this.board = board;
            }

            static Board fromCharMatrix(char[][] board) {
                return new Board(copyMatrix(toSquare(board)));
            }

            Board click(Coordinates coordinates) {
                Square[][] newBoard = copyMatrix(board);

                int row = coordinates.row;
                int col = coordinates.col;
                if (newBoard[row][col].isMine()) {
                    gameover(newBoard, coordinates);
                } else {
                    revealAll(newBoard, coordinates);
                }

                return new Board(newBoard);
            }

            char[][] asCharMatrix() {
                char[][] matrix = new char[getHeight()][getWidth()];
                for (int i = 0, height = getHeight(); i < height; ++i) {
                    for (int j = 0, width = getWidth(); j < width; ++j) {
                        matrix[i][j] = board[i][j].value;
                    }
                }
                return matrix;
            }

            private void gameover(Square[][] board, Coordinates coordinates) {
                board[coordinates.row][coordinates.col] = Square.REVEALED_MINE;
            }

            private void revealAll(Square[][] newBoard, Coordinates startCoordinates) {
                Deque<Coordinates> queue = new ArrayDeque<>();
                boolean[][] visited = new boolean[getHeight()][getWidth()];
                populateAndFlood(newBoard, queue, visited, startCoordinates.row, startCoordinates.col);
                while (!queue.isEmpty()) {
                    Coordinates coordinates = queue.poll();
                    int row = coordinates.row;
                    int col = coordinates.col;
                    if (!visited[row][col]) {
                        visit(row, col, newBoard, queue, visited);
                    }
                }
            }

            private void visit(int row, int col, Square[][] newBoard, Deque<Coordinates> queue, boolean[][] visited) {
                visited[row][col] = true;
                for (int rFrom = Math.max(0, row - 1), rTo = Math.min(getHeight() - 1, row + 1), r = rFrom; r <= rTo; r++) {
                    for (int cFrom = Math.max(0, col - 1), cTo = Math.min(getWidth() - 1, col + 1), c = cFrom; c <= cTo; c++) {
                        if (board[r][c].isEmpty()) {
                            populateAndFlood(newBoard, queue, visited, r, c);
                        }
                    }
                }
            }

            private void populateAndFlood(Square[][] newBoard, Deque<Coordinates> queue, boolean[][] visited, int r, int c) {
                int numAdjacentMines = countNumAdjacentMines(r, c);
                newBoard[r][c] = Square.fromNumAdjacentMines(numAdjacentMines);
                if (!visited[r][c] && numAdjacentMines == 0) {
                    queue.add(new Coordinates(r, c));
                }
            }

            private int getHeight() {
                return board.length;
            }

            private int getWidth() {
                return board[0].length;
            }

            private int countNumAdjacentMines(int row, int col) {
                return range(Math.max(0, row - 1), Math.min(getHeight() - 1, row + 1) + 1).map(
                        r -> range(Math.max(0, col - 1), Math.min(getWidth() - 1, col + 1) + 1).map(
                                c -> board[r][c].isMine() ? 1 : 0
                        ).sum()
                ).sum();
            }

            private static Square[][] toSquare(char[][] board) {
                int length = board.length;
                if (length == 0) {
                    return ZERO_SIZE_BOARD;
                } else {
                    Square[][] newBoard = new Square[length][board[0].length];
                    for (int i = 0, height = board.length; i < height; ++i) {
                        for (int j = 0, width = board[i].length; j < width; ++j) {
                            newBoard[i][j] = new Square(board[i][j]);
                        }
                    }
                    return newBoard;
                }
            }

            private static Square[][] copyMatrix(Square[][] board) {
                int length = board.length;
                if (length == 0) {
                    return ZERO_SIZE_BOARD;
                } else {
                    Square[][] newBoard = new Square[length][];
                    for (int i = 0; i < length; ++i) {
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
