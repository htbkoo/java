package online.codewars._6kyu;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Hey on 19 Jun 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/simple-card-game/train/java
 */

/*

Steve and Josh are bored and want to play something. They don't want to think too much, so they come up with a really simple game. Write a function called winner and figure out who is going to win.

They are dealt the same number of cards. They both flip the card on the top of their deck. Whoever has a card with higher value wins the round and gets one point (if the cards are of the same value, neither of them gets a point). After this, the two cards are discarded and they flip another card from the top of their deck. They do this until they have no cards left.

deckSteve and deckJosh are arrays representing their decks. They are filled with cards, represented by a single character. The card rank is as follows (from lowest to highest):

'2','3','4','5','6','7','8','9','T','J','Q','K','A'

Every card may appear in the deck more than once. Figure out who is going to win and return who wins and with what score:

"Steve wins x to y"

if Steve wins, where x is Steve's score, y is Josh's score;

"Josh wins x to y"

if Josh wins, where x is Josh's score, y is Steve's score;

"Tie"

if the score is tied at the end of the game.


Example:

Steve is dealt:

['A','7','8']

Josh is dealt:

['K','5','9']

    In first round, ace beats king and Steve gets one point.
    In second round, 7 beats 5 and Steve gets his second point.
    In third round, 9 beats 8 and Josh gets one point.


You should return:

"Steve wins 2 to 1"

* */

public class SimpleCardGame {
    public static class Game {

        private static Map<String, Integer> RANK = new HashMap<>();

        static {
            IntStream.range(2, 10).forEach(
                    i -> RANK.put(String.valueOf(i), i)
            );
            RANK.put("T", 10);
            RANK.put("J", 11);
            RANK.put("Q", 12);
            RANK.put("K", 13);
            RANK.put("A", 14);
        }

        public String winner(String[] deckSteve, String[] deckJosh) {
            // TODO
            final int length = deckSteve.length;
//            bad practice, but need to keep count of score if not tie
            final int[] draws = new int[]{0};

            final int steveScore = IntStream.range(0, length).map(
                    index -> {
                        final int compareTo = RANK.get(deckSteve[index]).compareTo(RANK.get(deckJosh[index]));
                        if (compareTo > 0) {
                            return 1;
                        }
                        if (compareTo == 0) {
                            ++draws[0];
                        }
                        return 0;
                    }
            ).sum();
            final int joshScore = (length - steveScore - draws[0]);
            if (steveScore == joshScore) {
                return "Tie";
            } else if (steveScore > joshScore) {
                return getWinMessage("Steve", steveScore, joshScore);
            } else {
                return getWinMessage("Josh", joshScore, steveScore);
            }
        }

        private String getWinMessage(String name, int xScore, int yScore) {
            return String.format("%s wins %d to %d", name, xScore, yScore);
        }
    }
}
