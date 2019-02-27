package online.atCoder.beginnerContext119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SyntheticKadomatsu {
    private static final int MP_CONSUMPTION_COMPOSITION_MAGIC = 10;

    public static int process(TestCase testCase) {
        int N = testCase.N;
        int A = testCase.A;
        int B = testCase.B;
        int C = testCase.C;
        List<Integer> l = testCase.l;

        List<Integer> targets = Arrays.asList(A, B, C);

        return generateConfigPermutations(N, targets.size())
                .stream()
                .filter(Config::isValid)
                .map(config -> config.asMpNeeded(targets, l))
                .mapToInt(i -> i)
                .min()
                .orElseThrow(() -> new IllegalStateException("Possibly programming bug, no valid config available"));
    }

    private static List<Config> generateConfigPermutations(int N, int numPossibleValues) {
        return IntStream.range(0, (int) Math.pow(numPossibleValues + 1, N))
                .boxed()
                .map(i -> Config.fromInt(N, numPossibleValues, i))
                .collect(toList());
    }

    private static class Config {
        //        private final List<Integer> assignedBamboos;
        private final boolean isValid;
        private final int[] occurrences;
        private final List<Integer> assignedBamboos;

        public static Config fromInt(int N, int numPossibleValues, Integer i) {
            final String unpadded = toUnpaddedConfigString(numPossibleValues + 1, i);
            final List<Integer> assignedBamboos = unpadded.chars()
                    .map(Character::getNumericValue)
                    .boxed()
                    .collect(toList());
            return new Config(assignedBamboos, numPossibleValues);
        }

        public boolean isValid() {
            return isValid;
        }

        public int asMpNeeded(List<Integer> targets, List<Integer> l) {
            return mpNeededForComposition() + mpNeededForLengthChanging(targets, l);
        }

        private Config(List<Integer> assignedBamboos, int numPossibleValues) {
            final int[] occurrences = countOccurrences(assignedBamboos, numPossibleValues);
            this.assignedBamboos = assignedBamboos;
            this.occurrences = occurrences;
            this.isValid = checkIsValid(occurrences, numPossibleValues);
        }

        private int mpNeededForComposition() {
            int mpNeeded = 0;
            for (int i = 1, numPossibleValues = occurrences.length; i < numPossibleValues; ++i) {
                mpNeeded += MP_CONSUMPTION_COMPOSITION_MAGIC * (occurrences[i] - 1);
            }
            return mpNeeded;
        }

        private int mpNeededForLengthChanging(List<Integer> targets, List<Integer> l) {
            int mpNeeded = 0;
            for (int i = 1, numPossibleValues = occurrences.length; i < numPossibleValues; ++i) {
                final int target = targets.get(i - 1);
                int combinedBambooLength = getCombinedBambooLength(i, l);
                mpNeeded += Math.abs(target - combinedBambooLength);
            }
            return mpNeeded; // todo
        }

        private int getCombinedBambooLength(int i, List<Integer> l) {
            int combinedBambooLength = 0;

            final int numAssignedBamboos = assignedBamboos.size();
            for (int j = numAssignedBamboos - 1; j >= 0; --j) {
                if (i == assignedBamboos.get(j)) {
                    final int pickedBambooLength = l.get(l.size() - 1 + j - (numAssignedBamboos - 1));
                    combinedBambooLength += pickedBambooLength;
                }
            }
            return combinedBambooLength;
        }

        private int[] countOccurrences(List<Integer> assignedBamboos, int numPossibleValues) {
            final int[] occurrences = new int[numPossibleValues + 1];
            assignedBamboos.forEach(i -> occurrences[i]++);
            return occurrences;
        }

        private boolean checkIsValid(int[] occurrences, int numPossibleValues) {
            for (int i = 1; i <= numPossibleValues; ++i) {
                if (occurrences[i] < 1) {
                    return false;
                }
            }
            return true;
        }

        private static String toUnpaddedConfigString(int N, Integer i) {
            return Integer.toString(i, N);
        }

//        private static String padToLength(int N, String unpadded) {
//            "0".
//            return "00000000".substring(unpadded.length()) + unpadded;
//        }
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final int result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            l.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, A, B, C, l);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int A;
        final int B;
        final int C;
        final List<Integer> l;

        public TestCase(int N, int A, int B, int C, final List<Integer> l) {
            this.N = N;
            this.A = A;
            this.B = B;
            this.C = C;
            this.l = l;
        }
    }
}
