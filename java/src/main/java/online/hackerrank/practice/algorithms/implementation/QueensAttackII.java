package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QueensAttackII {
    public static class Solution {
        private static class Board {
            private final Coordinates coor_q;
            private final Coordinates[][] nearestObstacles;

            Board(int n, Coordinates coor_q, int[][] obstacles) {
                this.coor_q = coor_q;
                this.nearestObstacles = initializeNearestObstacles(n, coor_q);

                Arrays.stream(obstacles)
                        .map(Coordinates::fromInts)
                        .filter(obstacle -> isRelevant(obstacle, coor_q))
                        .forEach(obstacle -> considerObstacle(obstacle, coor_q));
            }

            int count() {
                int count = 0;
                for (int dc = -1; dc <= 1; dc++) {
                    for (int dr = -1; dr <= 1; dr++) {
                        if (isValidDirection(dr, dc)) {
                            count += countOneDirection(dr, dc);
                        }
                    }
                }
                return count;
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
                Coordinates exist = getNearestObstacle(rowDirection, columnDirection);
                setNearestObstacle(rowDirection, columnDirection, coor_q.getCloser(exist, obstacle));
            }

            private Coordinates getNearestObstacle(int rowDirection, int columnDirection) {
                return nearestObstacles[rowDirection + 1][columnDirection + 1];
            }

            private void setNearestObstacle(int rowDirection, int columnDirection, Coordinates closer) {
                nearestObstacles[rowDirection + 1][columnDirection + 1] = closer;
            }

            private Coordinates[][] initializeNearestObstacles(int n, Coordinates coor_q) {
                Coordinates[][] nearestObstacles = new Coordinates[3][3];
                for (int dc = -1; dc <= 1; dc++) {
                    for (int dr = -1; dr <= 1; dr++) {
                        if (isValidDirection(dr, dc)) {
                            nearestObstacles[dr + 1][dc + 1] = initialNearestObstaclesForDirection(n, coor_q, new Coordinates(dr, dc));
                        }
                    }
                }

                return nearestObstacles;
            }

            private Coordinates initialNearestObstaclesForDirection(int n, Coordinates coor_q, Coordinates direction) {
                int dr = direction.r;
                int dc = direction.c;

                int r_q = coor_q.r;
                int c_q = coor_q.c;

                if (dr < 0) {
                    if (dc < 0) {
                        int distance = Math.min(r_q, c_q);
                        return new Coordinates(r_q - distance, c_q - distance);
                    } else if (dc == 0) {
                        return new Coordinates(0, c_q);
                    } else {
                        int distance = Math.min(r_q, n + 1 - c_q);
                        return new Coordinates(r_q - distance, c_q + distance);
                    }
                } else if (dr == 0) {
                    if (dc < 0) {
                        return new Coordinates(r_q, 1);
                    } else if (dc == 0) {
                        return new Coordinates(r_q, c_q);
                    } else {
                        return new Coordinates(r_q, n);
                    }
                } else {
                    if (dc < 0) {
                        int distance = Math.min(n - r_q, c_q - 1);
                        return new Coordinates(r_q + distance, c_q - distance);
                    } else if (dc == 0) {
                        return new Coordinates(n, c_q);
                    } else {
                        int distance = n - Math.max(r_q, c_q);
                        return new Coordinates(r_q + distance, c_q + distance);
                    }
                }
            }

            private int countOneDirection(int dr, int dc) {
                int linearDistance = getNearestObstacle(dr, dc).distanceFrom(coor_q) / (Math.abs(dr) + Math.abs(dc));
                return Math.max(0, linearDistance - 1);
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

            Coordinates getCloser(Coordinates exist, Coordinates obstacle) {
                if (distanceFrom(obstacle) < distanceFrom(exist)) {
                    return obstacle;
                } else {
                    return exist;
                }
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
