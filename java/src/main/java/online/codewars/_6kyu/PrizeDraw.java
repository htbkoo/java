package online.codewars._6kyu;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Hey on 25 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/prize-draw/train/java
 */

/*

To participate in a prize draw each one gives his/her firstname.

Each letter of a firstname has a value which is its rank in the English alphabet. A and a have rank 1, B and b rank 2 and so on.

The length of the firstname is added to the sum of these ranks hence a number n. An array of random weights is linked to the firstnames and each n is multiplied by its corresponding weight to get what they call a winning number.

Example: names: COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH weights: [1, 4, 4, 5, 2, 1]

PAUL -> n = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54 The weight associated with PAUL is 2 so Paul's winning number is 54 * 2 = 108.

Now one can sort the firstnames in decreasing order of the winning numbers. When two people have the same winning number sort them alphabetically by their firstnames.
Task:

parameters: st a string of firstnames, we an array of weights, n a rank

return: the firstname of the participant whose rank is n (ranks are numbered from 1)
Example:

names: COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH weights: [1, 4, 4, 5, 2, 1] n: 4

The function should return: PauL
Note:

If st is empty return "No participants".

If n is greater than the number of participants then return "Not enough participants".

* */

@SuppressWarnings("WeakerAccess")
public class PrizeDraw {
    public static class Rank {
        private static final String NO_PARTICIPANTS = "No participants";
        private static final String NOT_ENOUGH_PARTICIPANTS = "Not enough participants";

        public static String nthRank(String st, Integer[] we, int n) {
            // your code
            if (st.isEmpty()) {
                return NO_PARTICIPANTS;
            }

            final String[] firstNames = st.split(",");

            if ((n > we.length) || (n > firstNames.length)) {
                return NOT_ENOUGH_PARTICIPANTS;
            }

            final FirstNameWithWeight[] firstNameWithWeights = IntStream.range(0, firstNames.length).
                    mapToObj(index -> new FirstNameWithWeight(firstNames[index], we[index])).
                    toArray(FirstNameWithWeight[]::new);

            return Arrays.stream(firstNameWithWeights).
                    sorted().
                    toArray(FirstNameWithWeight[]::new)[n - 1].
                    getFirstName();
        }

        private static class FirstNameWithWeight implements Comparable<FirstNameWithWeight> {
            private final String firstName;
            private final Integer weight;

            public FirstNameWithWeight(String firstName, Integer weight) {
                this.firstName = firstName;
                this.weight = weight;
            }

            public String getFirstName() {
                return firstName;
            }

            @Override
            public int compareTo(FirstNameWithWeight o) {
                final int compare = Integer.compare(this.getWinningNumber(), o.getWinningNumber());
                return (compare == 0) ? this.firstName.compareTo(o.firstName) : -compare;
            }

            private int getWinningNumber() {
                return weight * (firstName.toUpperCase().chars().map(i -> 1 + i - 'A').sum() + firstName.length());
            }
        }
    }
}