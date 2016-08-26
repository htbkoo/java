package online.codewars._6kyu;

/**
 * Created by Hey on 24 Aug 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/sequences-and-series/train/java
 */

/*

Have a look at the following numbers.

 n | score
---+-------
 1 |  50
 2 |  150
 3 |  300
 4 |  500
 5 |  750

Can you find a pattern in it? If so, then write a function getScore(n) which returns the score for any positive number n:

getScore(1); // == 50
getScore(2); // == 150
getScore(3); // == 300
// ...

* */

@SuppressWarnings("WeakerAccess")
public class SequencesAndSeries {
    public static class Sequence {
        public static long getScore(long n) {
            // do your magic here
            return (n * (n + 1)) / 2 * 50;
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