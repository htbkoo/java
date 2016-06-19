package online.codewars._6kyu;

import org.junit.Test;

import static online.codewars._6kyu.SimpleCardGame.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 19 Jun 2016
 */
public class SimpleCardGameTest {
    private Game game = new Game();

    @Test
    public void testGame() {
        assertEquals(
                "small deck",
                "Steve wins 2 to 1",
                game.winner(new String[]{"A", "7", "8"}, new String[]{"K", "5", "9"})
        );

        assertEquals(
                "small deck",
                "Tie",
                game.winner(new String[]{"T"}, new String[]{"T"})
        );
    }
}