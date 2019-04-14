package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QueensAttackII {
    public static class Solution {
        private static class Board {
            private final int[][] numCanAttack;

            Board(int n, Coordinates coor_q, int[][] obstacles) {
                this.numCanAttack = initialize(n, coor_q);

                Arrays.stream(obstacles)
                        .map(Coordinates::fromInts)
                        .filter(obstacle -> isRelevant(obstacle, coor_q))
                        .forEach(obstacle -> considerObstacle(obstacle, coor_q));
            }

            int count() {
                return Arrays.stream(numCanAttack)
                        .map(row -> Arrays.stream(row).sum())
                        .mapToInt(i -> i)
                        .sum();
            }

            private boolean isValidDirection(int dr, int dc) {
                return dc != 0 || dr != 0;
            }

            private boolean isRelevant(Coordinates obstacle, Coordinates coor_q) {
                int r = obstacle.r;
                int c = obstacle.c;
                int r_q = coor_q.r;
                int r_c = coor_q.c;
                boolean isSameRow = r == r_q,
                        isSameColumn = c == r_c,
                        isSameDiagRightDown = (r + c) == (r_q + r_c),
                        isSameDiagRightUp = (r - c) == (r_q - r_c);
                return isSameRow || isSameColumn || isSameDiagRightDown || isSameDiagRightUp;
            }

            private void considerObstacle(Coordinates obstacle, Coordinates coor_q) {
                int rowDirection = Integer.signum(obstacle.r - coor_q.r);
                int columnDirection = Integer.signum(obstacle.c - coor_q.c);
                int exist = getNumCanAttack(rowDirection, columnDirection);
                setNumCanAttack(rowDirection, columnDirection, Math.min(exist, coor_q.linearDistanceFrom(rowDirection, columnDirection, obstacle) - 1));
            }

            private int getNumCanAttack(int rowDirection, int columnDirection) {
                return numCanAttack[rowDirection + 1][columnDirection + 1];
            }

            private void setNumCanAttack(int rowDirection, int columnDirection, int closer) {
                numCanAttack[rowDirection + 1][columnDirection + 1] = closer;
            }

            private int[][] initialize(int n, Coordinates coor_q) {
                int[][] numCanAttack = new int[3][3];
                for (int dc = -1; dc <= 1; dc++) {
                    for (int dr = -1; dr <= 1; dr++) {
                        if (isValidDirection(dr, dc)) {
                            numCanAttack[dr + 1][dc + 1] = initialNumCanAttackForDirection(n, coor_q, new Coordinates(dr, dc));
                        }
                    }
                }

                return numCanAttack;
            }

            private int initialNumCanAttackForDirection(int n, Coordinates coor_q, Coordinates direction) {
                int dr = direction.r;
                int dc = direction.c;

                int r_q = coor_q.r;
                int c_q = coor_q.c;

                if (dr < 0) {
                    int numRowFromBoardSide = r_q - 1;
                    if (dc < 0) {
                        return Math.min(numRowFromBoardSide, c_q - 1);
                    } else if (dc == 0) {
                        return numRowFromBoardSide;
                    } else {
                        return Math.min(numRowFromBoardSide, n - c_q);
                    }
                } else if (dr == 0) {
                    if (dc < 0) {
                        return c_q - 1;
                    } else if (dc == 0) {
                        return 0;
                    } else {
                        return n - c_q;
                    }
                } else {
                    int numRowFromBoardSide = n - r_q;
                    if (dc < 0) {
                        return Math.min(numRowFromBoardSide, c_q - 1);
                    } else if (dc == 0) {
                        return numRowFromBoardSide;
                    } else {
                        return Math.min(numRowFromBoardSide, n - c_q);
                    }
                }
            }
        }

        private static class Coordinates {
            final int r, c;

            private Coordinates(int r, int c) {
                this.r = r;
                this.c = c;
            }

            static Coordinates fromInts(int[] ints) {
                return new Coordinates(ints[0], ints[1]);
            }

            int linearDistanceFrom(int rowDirection, int columnDirection, Coordinates obstacle) {
                return distanceFrom(obstacle) / (Math.abs(rowDirection) + Math.abs(columnDirection));
            }

            private int distanceFrom(Coordinates other) {
                return Math.abs(r - other.r) + Math.abs(c - other.c);
            }
        }

        // Complete the queensAttack function below.
        static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
            Board board = new Board(n, new Coordinates(r_q, c_q), obstacles);
            return board.count();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            String[] r_qC_q = scanner.nextLine().split(" ");

            int r_q = Integer.parseInt(r_qC_q[0]);

            int c_q = Integer.parseInt(r_qC_q[1]);

            int[][] obstacles = new int[k][2];

            for (int i = 0; i < k; i++) {
                String[] obstaclesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles[i][j] = obstaclesItem;
                }
            }

            int result = queensAttack(n, k, r_q, c_q, obstacles);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }

    }
}
