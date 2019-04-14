package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CatsAndAMouse {

    public static class Solution {

        private static final String CAT_A = "Cat A";
        private static final String CAT_B = "Cat B";
        private static final String MOUSE_C = "Mouse C";

        // Complete the catAndMouse function below.
        static String catAndMouse(int x, int y, int z) {
            int aDist = Math.abs(x - z);
            int bDist = Math.abs(y - z);

            if (aDist == bDist) {
                return MOUSE_C;
            } else if (aDist < bDist) {
                return CAT_A;
            } else {
                return CAT_B;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String[] xyz = scanner.nextLine().split(" ");

                int x = Integer.parseInt(xyz[0]);

                int y = Integer.parseInt(xyz[1]);

                int z = Integer.parseInt(xyz[2]);

                String result = catAndMouse(x, y, z);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }

    }
}
