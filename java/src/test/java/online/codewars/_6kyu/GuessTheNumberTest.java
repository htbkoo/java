package online.codewars._6kyu;

import online.codewars._6kyu.GuessTheNumber.GuesserSolution;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Random;

import static online.codewars._6kyu.GuessTheNumber.CORRECT;
import static online.codewars._6kyu.GuessTheNumber.GuessProcessor;
import static online.codewars._6kyu.GuessTheNumber.TOO_HIGH;
import static online.codewars._6kyu.GuessTheNumber.TOO_LOW;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Hey on 12 Jun 2016
 */

// TODO: TDD development by writing your own tests as you solve the kata

public class GuessTheNumberTest {

    private static final GuessProcessor defaultGuessProcessor = new GuessProcessor() {
        private Random RANDOM = null;
        private final int GENERATED_BY_FAIR_DICE = 444;
        private int theNumber = GENERATED_BY_FAIR_DICE;

        @Override
        public String process(int guessAttempt) {
            if (guessAttempt == theNumber) {
                return CORRECT;
            } else if (guessAttempt < theNumber) {
                return TOO_LOW;
            } else {
                return TOO_HIGH;
            }
        }

        public void randomizeTheNumber() {
            theNumber = getRandom().nextInt(1000) + 1;
        }

        private Random getRandom() {
            if (RANDOM == null) {
                RANDOM = new Random();
            }
            return RANDOM;
        }
    };

    @Test
    public void testGuessProcessorLogic() throws Exception {
        assertThat(ReflectionTestUtils.getField(defaultGuessProcessor, "theNumber"), is(444));
        assertThat(defaultGuessProcessor.process(2), is(TOO_LOW));
        assertThat(defaultGuessProcessor.process(444), is(CORRECT));
        assertThat(defaultGuessProcessor.process(999), is(TOO_HIGH));
    }

    @Test
    public void testSomething() {
        final GuesserSolution guesserSolution = new GuesserSolution();
        guesserSolution.setGuessProcessor(defaultGuessProcessor);
        assertThat(guesserSolution.getNumber(), is(444));
        // assertEquals("expected", "actual");
    }

}