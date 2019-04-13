package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QueensAttackII {
    public static class Solution {
        private static class Board {
            final boolean[][] isObstacle;

            Board(int n, int[][] obstacles) {
                isObstacle = new boolean[n + 1][n + 1];
                Arrays.stream(obstacles)
                        .forEach(coordinates -> {
                            int r = coordinates[0];
                            int c = coordinates[1];
                            isObstacle[r][c] = true;
                        });
            }

            static Board fromObstaclesList(int n, int[][] obstacles) {
                return new Board(n, obstacles);
            }

            boolean isObstacle(int r, int c) {
                return isObstacle[r][c];
            }
        }

        // Complete the queensAttack function below.
        static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
            int count = 0;
            Board board = Board.fromObstaclesList(n, obstacles);
            for (int dc = -1; dc <= 1; dc++) {
                for (int dr = -1; dr <= 1; dr++) {
                    boolean isValidDirection = dc != 0 || dr != 0;
                    if (isValidDirection) {
                        count += countOneDirection(n, k, r_q, c_q, board, dc, dr);
                    }
                }
            }
            return count;
        }

        private static int countOneDirection(int n, int k, int r_q, int c_q, Board board, int dc, int dr) {
            r_q += dr;
            c_q += dc;
            int count = 0;
            while (isWithinRange(n, r_q, c_q) && !board.isObstacle(r_q, c_q)) {
                count++;
                r_q += dr;
                c_q += dc;
            }
            return count;
        }

        private static boolean isWithinRange(int n, int r_q, int c_q) {
            return r_q >= 1 && c_q >= 1 && r_q <= n && c_q <= n;
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
