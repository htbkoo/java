package online.atCoder.beginnerContext123;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FiveDishes {
    private static final int INTERVAL = 10;

    private static class Dish {
        final int time;
        final int roundUp;
        final int timeWasted;

        private Dish(int time, int roundUp, int timeWasted) {
            this.time = time;
            this.roundUp = roundUp;
            this.timeWasted = timeWasted;
        }

        static Dish fromInt(int i) {
            int roundUp = ((i + INTERVAL - 1) / INTERVAL) * INTERVAL;
            int timeWasted = roundUp - i;
            return new Dish(i, roundUp, timeWasted);
        }

        int getTimeWasted() {
            return this.timeWasted;
        }

        int getRoundUp() {
            return this.roundUp;
        }
    }

    public static String process(int a, int b, int c, int d, int e) {
        List<Dish> dishes = Stream.of(a, b, c, d, e)
                .map(Dish::fromInt)
                .sorted(Comparator.comparing(Dish::getTimeWasted))
                .collect(Collectors.toList());

        int lastDish = dishes.size() - 1;
        int lastDishTime = dishes.get(lastDish).time;
        int totalTime = lastDishTime + IntStream.range(0, lastDish).mapToObj(dishes::get).mapToInt(Dish::getRoundUp).sum();

        return String.valueOf(totalTime);
    }
    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        final String result = process(a, b, c, d, e);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
