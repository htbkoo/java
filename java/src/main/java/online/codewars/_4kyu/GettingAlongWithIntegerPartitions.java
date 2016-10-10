package online.codewars._4kyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * Created by Hey on 10 Oct 2016
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/getting-along-with-integer-partitions/train/java
 */

/*

From wikipedia https://en.wikipedia.org/wiki/Partition_(number_theory):

In number theory and combinatorics, a partition of a positive integer n, also called an integer partition, is a way of writing n as a sum of positive integers. Two sums that differ only in the order of their summands are considered the same partition.

For example, 4 can be partitioned in five distinct ways:

4, 3 + 1, 2 + 2, 2 + 1 + 1, 1 + 1 + 1 + 1.

We can write:

enum(4) -> [[4],[3,1],[2,2],[2,1,1],[1,1,1,1]] and

enum(5) -> [[5],[4,1],[3,2],[3,1,1],[2,2,1],[2,1,1,1],[1,1,1,1,1]].

The number of parts in a partition grows very fast. For n = 50 number of parts is 204226, for 80 it is 15,796,476 It would be too long to tests answers with arrays of such size. So our task is the following:

1 - n being given (n integer, 1 <= n <= 50) calculate enum(n) ie the partition of n. We will obtain something like that:
enum(n) -> [[n],[n-1,1],[n-2,2],...,[1,1,...,1]] (order of array and sub-arrays doesn't matter). This part is not tested.

2 - For each sub-array of enum(n) calculate its product. If n = 5 we'll obtain after removing duplicates and sorting:

prod(5) -> [1,2,3,4,5,6]

prod(8) -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 16, 18]

If n = 40 prod(n) has a length of 2699 hence the tests will not verify such arrays. Instead our task number 3 is:

3 - return the range, the average and the median of prod(n) in the following form (example for n = 5):

"Range: 5 Average: 3.50 Median: 3.50"

Range is an integer, Average and Median are float numbers rounded to two decimal places (".2f" in some languages).
Notes:

Range : difference between the highest and lowest values.

Mean or Average : To calculate mean, add together all of the numbers in a set and then divide the sum by the total count of numbers.

Median : The median is the number separating the higher half of a data sample from the lower half. (https://en.wikipedia.org/wiki/Median)
Hints:

Try to optimize your program to avoid timing out.

Memoization can be helpful but it is not mandatory for being successful.

* */

public class GettingAlongWithIntegerPartitions {
    public static class IntPart {
        private static List<TreeSet<Long>> prods = new ArrayList<>(Collections.singletonList(new TreeSet<>(Collections.singletonList(1L))));

        private static String getAsString(List<Long> sortedProd) {
            final int size = sortedProd.size();
            long range = sortedProd.get(size - 1) - sortedProd.get(0);
            double average = sortedProd.stream().mapToLong(Long::longValue).average().orElse(0D);

            // Explicit Casting is necessary - otherwise we would got a compilation error
            //noinspection TrivialFunctionalExpressionUsage
            double median = ((Function<List<Long>, Double>) ((l) ->
                    (size % 2 == 0) ?
                            (l.get(size / 2) + l.get(size / 2 - 1)) / 2D :
                            l.get(size / 2) / 1D)).
                    apply(sortedProd);
            return String.format("Range: %d Average: %.2f Median: %.2f", range, average, median);
        }

        public static String part(long n) {
            // your code
            final int size = prods.size() + 1;
            LongStream.range(size, n + 1).
                    forEach(i -> {
                        final TreeSet<Long> curr = new TreeSet<>();
                        curr.add(i);
                        LongStream.range(1, i).
                                forEach(j -> prods.get((int) (i - j - 1)).
                                        forEach(d -> curr.add(j * d)
                                        )
                                );
                        prods.add(curr);
                    });
            return getAsString(new ArrayList<>(prods.get((int) (n - 1))));
        }

    }

//    Ignore
    public static class FailedAttemptUsingList {
        public static class IntPart {
            private static List<List<Long>> prods = Collections.singletonList((Collections.singletonList(1L)));
//        private static List<Long> prods = new ArrayList<>();

            private static String getAsString(List<Long> sortedProd) {
                final int size = sortedProd.size();
                long range = sortedProd.get(size - 1) - sortedProd.get(0);
                double average = sortedProd.stream().mapToLong(Long::longValue).average().orElse(0D);

                // Explicit Casting is necessary - otherwise we would got a compilation error
                //noinspection TrivialFunctionalExpressionUsage
                double median = ((Function<List<Long>, Double>) ((l) ->
                        (size % 2 == 0) ?
                                (sortedProd.get(size / 2) + sortedProd.get(size / 2 - 1)) / 2D :
                                sortedProd.get(size / 2) / 1D)).
                        apply(sortedProd);
                return String.format("Range: %d Average: %.2f Median: %.2f", range, average, median);
            }

            public static String part(long n) {
                // your code
//            for case n=1
                List<Long> curr = prods.get(0);
                for (long i = 2; i <= n; ++i) {
                    curr = prods.get((int) i);
                    //noinspection StatementWithEmptyBody
                    for (long j = 1; j <= i; ++j) {

                    }
//                NOT NECESSARY: check if optional
//                curr.sort(Long::compare);
                }
                return getAsString(curr);
            }

        }
    }
}
