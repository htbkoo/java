package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.util.stream.IntStream.range;

public class ThreeDSurfaceArea {
    public static class Solution {
        // Complete the surfaceArea function below.
        static int surfaceArea(int[][] A) {
            int H = A.length, W = A[0].length;

            int bottomArea = H * W;
            int topArea = H * W;
            return bottomArea + topArea + sidesArea(A, H, W);
        }

        private static int sidesArea(int[][] A, int H, int W) {
            return range(0, H).map(h ->
                    range(0, W).map(w ->
                            getFourSidesDiff(h, w, A, H, W)
                    ).sum()
            ).sum();
        }

        private static int getFourSidesDiff(int h, int w, int[][] A, int H, int W) {
            int targetHeight = safeGetHeight(h, w, A, H, W);

            return sideDiff(targetHeight, h - 1, w, A, H, W)
                    + sideDiff(targetHeight, h, w - 1, A, H, W)
                    + sideDiff(targetHeight, h + 1, w, A, H, W)
                    + sideDiff(targetHeight, h, w + 1, A, H, W);
        }

        private static int sideDiff(int targetHeight, int hSide, int WSide, int[][] A, int H, int W) {
            return Math.max(0, targetHeight - safeGetHeight(hSide, WSide, A, H, W));
        }

        private static int safeGetHeight(int h, int w, int[][] A, int H, int W) {
            if (h >= 0 && w >= 0 && h < H && w < W) {
                return A[h][w];
            } else {
                return 0;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] HW = scanner.nextLine().split(" ");

            int H = Integer.parseInt(HW[0]);

            int W = Integer.parseInt(HW[1]);

            int[][] A = new int[H][W];

            for (int i = 0; i < H; i++) {
                String[] ARowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < W; j++) {
                    int AItem = Integer.parseInt(ARowItems[j]);
                    A[i][j] = AItem;
                }
            }

            int result = surfaceArea(A);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
