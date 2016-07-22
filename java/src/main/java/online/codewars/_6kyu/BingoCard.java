package online.codewars._6kyu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Hey on 21 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/bingo-card/train/java
 */

/*

After yet another dispute on their game the Bingo Association decides to change course and automize the game.

Can you help the association by writing a method to create a random bingo card?

Task:

    Finish method:

    BingoCard.getCard()

    A bingo card contains 24 unique and random numbers according to this scheme:
        5 numbers from the B column in the range 1 to 15
        5 numbers from the I column in the range 16 to 30
        4 numbers from the N column in the range 31 to 45
        5 numbers from the G column in the range 46 to 60
        5 numbers from the O column in the range 61 to 75

    The card must be returned as an array of bingo style numbers:

    {"B14", "B12", "B5", "B6", "B3", "I28", "I27", ... }

    The numbers must be in the order of their column: B, I, N, G, O. Within the columns the order of the numbers is random.

* */

@SuppressWarnings("WeakerAccess")
public class BingoCard {
    private static final Column[] columns = new Column[]{
            new Column("B", 1, 16, 5),
            new Column("I", 16, 31, 5),
            new Column("N", 31, 46, 4),
            new Column("G", 46, 61, 5),
            new Column("O", 61, 76, 5),
    };

    public static String[] getCard() {
        // Write your code here...
        return Arrays.
                stream(columns).
                flatMap(column -> ShufflingPseudoRandomNumberGenerator.
                        generate(column.getStartInclusive(), column.getEndExclusive(), column.getCount()).
                        stream().
                        map(i -> String.format("%s%d", column.getTitle(), i)))
                .toArray(String[]::new);
    }

    private static class ShufflingPseudoRandomNumberGenerator {
        private static List<Integer> generate(int startInclusive, int endExclusive, int count) {
            final List<Integer> list = IntStream.
                    range(startInclusive, endExclusive).
                    boxed().
                    collect(Collectors.toList()
                    );
            Collections.shuffle(list);
            return list.subList(0, count);
        }
    }

    private static class Column {
        private final String title;
        private final int startInclusive;


        private final int endExclusive;
        private final int count;

        private Column(String title, int startInclusive, int endExclusive, int count) {
            this.title = title;
            this.startInclusive = startInclusive;
            this.endExclusive = endExclusive;
            this.count = count;
        }

        public String getTitle() {
            return title;
        }

        public int getEndExclusive() {
            return endExclusive;
        }

        public int getStartInclusive() {
            return startInclusive;
        }

        public int getCount() {
            return count;
        }
    }
}


//    Failed stream attempt

/*        return Arrays.
                stream(columns).
                map(
                        c -> ShufflingPseudoRandomNumberGenerator.
                                generate(c.getStartInclusive(), c.getEndExclusive(), c.getCount()).
                                stream().
                                map(i -> String.format("%s%d", c.getTitle(), i))
                ).reduce(Stream::concat).
                orElse(Stream.empty()).
                collect(Collectors.toList())
                toArray(new String[24]);*/