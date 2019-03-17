package online.atCoder.beginnerContext107;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class GridCompression {
    private static final String BLACK = "#";

    @SuppressWarnings("unused")
    public static List<String> process(int H, int W, List<String> a) {
        final List<String> removedBlankRows = a.stream().filter(GridCompression::keepRowWithAnyBlack).collect(Collectors.toList());
        final List<String> transposed = transpose(removedBlankRows);
        final List<String> compressedTranspose = transposed.stream().filter(GridCompression::keepRowWithAnyBlack).collect(Collectors.toList());

        return transpose(compressedTranspose);
    }

    private static boolean keepRowWithAnyBlack(String row) {
        return row.chars().anyMatch(GridCompression::isBlack);
    }

    private static boolean isBlack(int c) {
        return c == BLACK.codePointAt(0);
    }

    private static List<String> transpose(List<String> grid) {
        if (grid.isEmpty()) {
            return new ArrayList<>();
        } else {
            final int W = grid.get(0).length();

            return IntStream.range(0, W)
                    .boxed()
                    .map(i -> grid.stream().map(row -> row.substring(i, i + 1)).collect(joining()))
                    .collect(Collectors.toList());
        }
    }

    // Util Func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        final List<String> a = IntStream.range(0, H).mapToObj(i -> sc.next()).collect(Collectors.toList());

        // process
        final List<String> result = process(H, W, a);

        // output
        result.forEach(System.out::println);
    }
}