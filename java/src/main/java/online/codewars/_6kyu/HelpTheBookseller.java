package online.codewars._6kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Hey on 13 Aug 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/help-the-bookseller/train/java
 */

/*

A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.

In a given stocklist all codes have the same length and all numbers have their own same length (can be different from the code length).

For example an extract of one of the stocklists could be:

L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.

In this stocklist all codes have a length of five and all numbers have a length of two.

You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :

  M = {"A", "B", "C", "W"}

and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity according to each category. You will have first to determine the common length of the codes and the common length of the quantities in L.

For the lists L and M of example you have to return the string (in Haskell/Clojure a list of pairs):

  (A : 20) - (B : 114) - (C : 50) - (W : 0)

where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.

If L or M are empty return string is "" (Clojure should return an empty array instead).

* */

@SuppressWarnings("WeakerAccess")
public class HelpTheBookseller {
    public static class StockList {

        private static class Stock {
            private final String code;
            private final int quantity;

            public Stock(String l) {
                final String[] strings = l.split(" ");
                code = strings[0];
                quantity = Integer.parseInt(strings[1]);
            }

            public String getCode() {
                return code;
            }

            public int getQuantity() {
                return quantity;
            }
        }

        private static class AggregatedPair {
            private final String category;
            private final int quantity;

            private AggregatedPair(String category, int quantity) {
                this.category = category;
                this.quantity = quantity;
            }

            @Override
            public String toString() {
                return String.format("(%s : %d)", category, quantity);
            }
        }

        // 1st parameter is the stocklist (L in example),
        // 2nd parameter is list of categories (M in example)
        public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
            // your code here
            if ((lstOf1stLetter.length == 0) || (lstOfArt.length == 0)) {
                return "";
            }

            return Arrays.stream(lstOf1stLetter).map(
                    cat -> new AggregatedPair(
                            cat,
                            Arrays.stream(lstOfArt).
                                    map(Stock::new).
                                    filter(stock -> cat.equals(stock.getCode().substring(0, 1))).
                                    mapToInt(Stock::getQuantity).
                                    sum()
                    ).toString()
            ).collect(Collectors.joining(" - "));
        }
    }
}