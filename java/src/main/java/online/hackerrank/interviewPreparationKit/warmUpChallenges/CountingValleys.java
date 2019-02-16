package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountingValleys {
    public static class Solution {

        enum Path {
            U(1), D(-1);

            private final int altitudeChange;

            Path(int altitudeChange) {
                this.altitudeChange = altitudeChange;
            }

            public int getAltitudeChange() {
                return altitudeChange;
            }
        }

        // Complete the countingValleys function below.
        static int countingValleys(int n, String s) {
            int altitude = 0, numValleys = 0;
            boolean isBelowSeaLevel = false;
            final List<Integer> altitudeChanges = Arrays.stream(s.split(""))
                    .map(Path::valueOf)
                    .map(Path::getAltitudeChange)
                    .collect(Collectors.toList());
            for (int altitudeChange : altitudeChanges) {
                int newAltitude = altitude + altitudeChange;
                if (isBelowSeaLevel) {
                    if (newAltitude >= 0) {
                        isBelowSeaLevel = false;
                        numValleys++;
                    }
                } else {
                    if (newAltitude < 0) {
                        isBelowSeaLevel = true;
                    }
                }
                altitude = newAltitude;
            }

            return numValleys;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String s = scanner.nextLine();

            int result = countingValleys(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
