package online.atCoder.beginnerContext119;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class LazyFaith {
    private static final long IMPOSSIBLE_DISTANCE = 30_000_000_000L;

    public static List<Long> process(TestCase testCase) {
        List<Long> s = sorted(testCase.s);
        List<Long> t = sorted(testCase.t);

        List<Long> x = testCase.x;

        return x.stream().map(xi -> solveForTestCase(xi, s, t)).collect(toList());
    }

    private static List<Long> sorted(List<Long> list) {
        list.sort(Long::compareTo);
        return list;
    }

    private static long solveForTestCase(Long xi, List<Long> s, List<Long> t) {
        final ClosestPositions sClosestPositions = ClosestPositions.fromListAndTarget(s, xi);
        final ClosestPositions tClosestPositions = ClosestPositions.fromListAndTarget(t, xi);

        return findBest(sClosestPositions, tClosestPositions, xi);
    }

    private static long findBest(ClosestPositions sClosestPositions, ClosestPositions tClosestPositions, Long xi) {
        final Long sLeft = sClosestPositions.leftClosest.orElse(IMPOSSIBLE_DISTANCE);
        final Long tLeft = tClosestPositions.leftClosest.orElse(IMPOSSIBLE_DISTANCE);
        final Long sRight = sClosestPositions.rightClosest.orElse(IMPOSSIBLE_DISTANCE);
        final Long tRight = tClosestPositions.rightClosest.orElse(IMPOSSIBLE_DISTANCE);

        long distSLeft = distance(xi, sLeft);
        long distTLeft = distance(xi, tLeft);
        long distSRight = distance(xi, sRight);
        long distTRight = distance(xi, tRight);

        long distLL = Math.max(distSLeft, distTLeft);
        long distRR = Math.max(distSRight, distTRight);
        long distLR = distance(sLeft, tRight) + Math.min(distSLeft, distTRight);
        long distRL = distance(sRight, tLeft) + Math.min(distSRight, distTLeft);

        return Math.min(Math.min(Math.min(distLL, distRR), distLR), distRL);
    }

    private static Long unsafeGet(Optional<Long> pos) {
        return pos.orElseThrow(() -> new IllegalStateException("Programming bug"));
    }

    private static long distance(Long xi, Long from) {
        return Math.abs(from - xi);
    }

    public static class ClosestPositions {
        private final Optional<Long> leftClosest;
        private final Optional<Long> rightClosest;

        private ClosestPositions(Optional<Long> leftClosest, Optional<Long> rightClosest) {
            this.leftClosest = leftClosest;
            this.rightClosest = rightClosest;
        }

        public static ClosestPositions fromListAndTarget(List<Long> list, Long xi) {
            final int size = list.size();

            final boolean isLeftmost = xi < list.get(0);
            if (isLeftmost) {
                return new ClosestPositions(Optional.empty(), Optional.of(list.get(0)));
            }

            final boolean isRightmost = xi > list.get(size - 1);
            if (isRightmost) {
                return new ClosestPositions(Optional.of(list.get(size - 1)), Optional.empty());
            }

            int lo = 0, hi = size - 1, mid;

            while (lo <= hi) {
                mid = (lo + hi + 1) / 2;
                final Long midValue = list.get(mid);
                if (xi.equals(midValue)) {
                    final Optional<Long> closest = Optional.of(midValue);
                    return new ClosestPositions(closest, closest);
                } else if (xi > midValue) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            final Optional<Long> leftClosest = Optional.of(list.get(Math.min(lo, hi)));
            final Optional<Long> rightClosest = Optional.of(list.get(Math.max(lo, hi)));
            return new ClosestPositions(leftClosest, rightClosest);
        }

        public Optional<Long> getLeftClosest() {
            return leftClosest;
        }

        public Optional<Long> getRightClosest() {
            return rightClosest;
        }

    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final List<Long> result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int Q = sc.nextInt();
        List<Long> s = readLongs(sc, A);
        List<Long> t = readLongs(sc, B);
        List<Long> x = readLongs(sc, Q);

        sc.close();
        return new TestCase(A, B, Q, s, t, x);
    }

    private static List<Long> readLongs(Scanner sc, int n) {
        List<Long> l = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            l.add(sc.nextLong());
        }
        return l;
    }

    private static void output(List<Long> result) {
        result.forEach(System.out::println);
    }

    public static class TestCase {
        final int A;
        final int B;
        final int Q;
        final List<Long> s;
        final List<Long> t;
        final List<Long> x;

        public TestCase(int A, int B, int Q, final List<Long> s, List<Long> t, List<Long> x) {
            this.A = A;
            this.B = B;
            this.Q = Q;
            this.s = s;
            this.t = t;
            this.x = x;
        }
    }
}
