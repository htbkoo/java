package online.atCoder.regularContext097;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

public class SortedAndSorted {

    private static final int START_WITH_ZERO_OP = 0;

    public static String process(TestCase testCase) {
        final int N = testCase.N;
        final List<String> c = testCase.c;
        final List<Integer> a = testCase.a;

        final State initialState = State.newState(N, c, a);

        return String.valueOf(BFS(initialState));
    }

    private static int BFS(State initialState) {
        Deque<State> queue = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();

        State currentState = initialState;
        while (!currentState.isValid()) {
            visited.add(currentState);
            queue.addAll(currentState.neighbourStates()
                    .stream()
                    .filter(state -> !visited.contains(state))
                    .collect(toList())
            );
            currentState = queue.poll();
            if (currentState == null) {
                throw new IllegalStateException("no more unvisited states - queue is empty");
            }
        }

        return currentState.opCount;
    }

    private static class State {
        final List<Ball> balls;
        final int opCount;

        static State newState(final int N, final List<String> c, final List<Integer> a) {
            final List<Ball> balls = range(0, 2 * N).mapToObj(i -> toBall(i, c, a)).collect(toList());
            return new State(balls, START_WITH_ZERO_OP);
        }

        public boolean isValid() {
            int blackMax = 0, whiteMax = 0;
            for (Ball ball : balls) {
                switch (ball.colour) {
                    case W: {
                        if (whiteMax > ball.order) {
                            return false;
                        } else {
                            whiteMax = ball.order;
                        }
                        break;
                    }
                    case B: {
                        if (blackMax > ball.order) {
                            return false;
                        } else {
                            blackMax = ball.order;
                        }
                        break;
                    }
                }
            }
            return true;
        }

        public Set<State> neighbourStates() {
            return range(1, balls.size())
                    .mapToObj(i -> new State(getNewBallsAfterSwapping(i - 1, i), opCount + 1))
                    .collect(toSet());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return balls.equals(state.balls);
        }

        @Override
        public int hashCode() {
            return Objects.hash(balls);
        }

        @Override
        public String toString() {
            return balls.stream().map(Ball::toString).collect(joining());
        }

        private State(List<Ball> balls, int opCount) {
            this.balls = balls;
            this.opCount = opCount;
        }

        private static Ball toBall(int i, List<String> c, List<Integer> a) {
            final String ci = c.get(i);
            final int ai = a.get(i);
            return new Ball(ci, ai);
        }

        private List<Ball> getNewBallsAfterSwapping(int a, int b) {
            List<Ball> newBalls = new ArrayList<>(balls);
            Ball temp = newBalls.get(a);
            newBalls.set(a, newBalls.get(b));
            newBalls.set(b, temp);
            return newBalls;
        }
    }

    private static class Ball {
        final Colour colour;
        final int order;

        Ball(String colour, int order) {
            this.colour = Colour.fromString(colour);
            this.order = order;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ball ball = (Ball) o;
            return order == ball.order &&
                    colour == ball.colour;
        }

        @Override
        public int hashCode() {
            return Objects.hash(colour, order);
        }

        @Override
        public String toString() {
            return String.format("%s%d", colour.name(), order);
        }
    }

    private enum Colour {
        B, W;

        static Colour fromString(String s) {
            return Arrays.stream(values())
                    .filter(colour -> colour.name().equals(s))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown colour: " + s));
        }
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<String> c = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        range(0, 2 * N).forEach(i -> {
            c.add(sc.next());
            a.add(sc.nextInt());
        });

        return new TestCase(N, c, a);
    }


    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final List<String> c;
        final List<Integer> a;

        public TestCase(int N, List<String> c, List<Integer> a) {
            this.N = N;
            this.c = c;
            this.a = a;
        }
    }
}
