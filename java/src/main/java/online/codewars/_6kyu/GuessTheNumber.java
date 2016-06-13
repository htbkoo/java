package online.codewars._6kyu;

/**
 * Created by Hey on 15 May 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/guess-the-number-1/train/java
 */

/*

The Guesser class is set up to generate a random number from 1-1000, and allows 10 guesses to get the number.

Your task is to write a method 'get_number' (Guesser.prototype.getNumber() in javascript) inside the Guesser class to identify a random number from 1-1000.

You should use the method:

guess(number)

Which will return either:

"Too high!" If the guess is too high.
"Too low!" If the guess is too low.
or "Correct!" If the guess is correct.

You can only call this method 10 times before an exception is raised.

* */

public class GuessTheNumber {
    protected interface GuessProcessor {
        String process(int x);
    }

    protected static abstract class AbstractGuessProcessor implements GuessProcessor {
        @Override
        public abstract String process(int x);

    }

    protected static abstract class Guesser {
        private GuessProcessor guessProcessor;
        private int guessedMade = 0;

        public abstract int getNumber();

        protected String guess(int x) {
            if (guessedMade < 10) {
                ++guessedMade;
                return guessProcessor.process(x);
            } else {
                throw new IllegalStateException("Too many guess attempts made!");
            }
        }

        public void setGuessProcessor(GuessProcessor guessProcessor) {
            this.guessProcessor = guessProcessor;
        }
    }

    protected static final String TOO_HIGH = "Too high!";
    protected static final String TOO_LOW = "Too low!";
    protected static final String CORRECT = "Correct!";

    public static class GuesserSolution extends Guesser {

        @Override
        public int getNumber() {
            int lowerBound = 1;
            int upperBound = 1000;
            while (true) {
                int mid = (lowerBound + upperBound) / 2;
                final String guessResult = guess(mid);
                if (CORRECT.equals(guessResult)) {
                    return mid;
                } else if (TOO_LOW.equals(guessResult)) {
                    lowerBound = mid;
                } else {
                    upperBound = mid;
                }
            }
        }
    }

}
