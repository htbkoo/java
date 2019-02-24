package online.atCoder.beginnerContext116;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DpTleVariousSushi {
    public static long process(TestCase testCase) {
        final int N = testCase.N;
        final int K = testCase.K;
        List<Integer> t = testCase.t;
        List<Integer> d = testCase.d;

        Answer[][] answers = initializeAnswers(N, K);

        for (int i = 1; i <= K; ++i) {
            for (int j = 1; j <= N; ++j) {
                answers[i][j] = computeAnswer(answers, i, j, t.get(j - 1), d.get(j - 1));
            }
        }

        return answers[K][N].getValue();
    }

    private static Answer[][] initializeAnswers(int N, int K) {
        final Answer[][] answers = new Answer[K + 1][N + 1];

        for (int i = 0; i <= K; ++i) {
            answers[i][0] = Answer.zero();
        }

        for (int i = 0; i <= N; ++i) {
            answers[0][i] = Answer.zero();
        }

        return answers;
    }

    private static Answer computeAnswer(Answer[][] answers, int i, int j, int t, int d) {
        final Answer takeSushiAnswer = answers[i - 1][j - 1].withSushi(t, d);
        final Answer notTakeSushiAnswer = answers[i][j - 1];

        return chooseAnswer(takeSushiAnswer, notTakeSushiAnswer);
    }

    private static Answer chooseAnswer(Answer takeSushiAnswer, Answer notTakeSushiAnswer) {
        long takeSushiValue = takeSushiAnswer.getValue();
        long takeSushiVariety = takeSushiAnswer.getVariety();

        long notTakeSushiValue = notTakeSushiAnswer.getValue();
        long notTakeSushiVariety = notTakeSushiAnswer.getVariety();

        if (takeSushiValue > notTakeSushiValue) {
            return takeSushiAnswer;
        } else if (takeSushiValue < notTakeSushiValue) {
            return notTakeSushiAnswer;
        } else {
            if (takeSushiVariety > notTakeSushiVariety) {
                return takeSushiAnswer;
            } else {
                return notTakeSushiAnswer;
            }
        }
    }

    private static class Answer {
        private final long d;
        private final Set<Integer> kinds;

        public static Answer zero() {
            return new Answer(0, Collections.emptySet());
        }

        public Answer withSushi(int t, int d) {
            final long newD = this.d + d;

            final Set<Integer> newKinds = new HashSet<>(this.kinds);
            newKinds.add(t);

            return new Answer(newD, newKinds);
        }

        private Answer(long d, Set<Integer> kinds) {
            this.d = d;
            this.kinds = new HashSet<>(kinds);
        }

        public long getValue() {
            final long variety = kinds.size();
            return d + variety * variety;
        }

        public int getVariety() {
            return kinds.size();
        }
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final long result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> t = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            t.add(sc.nextInt());
            d.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, K, t, d);
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int K;
        final List<Integer> t;
        final List<Integer> d;

        public TestCase(int N, int K, List<Integer> t, List<Integer> d) {
            this.N = N;
            this.K = K;
            this.t = t;
            this.d = d;
        }
    }
}
