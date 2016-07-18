package online.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 15 Jul 2016
 */

// Could not use Test infrastructure because it requires special constructor

@RunWith(Parameterized.class)
public class GuessNumberHigherOrLowerTest {

    private final static class GuessNumberHigherOrLowerTestParameters {
        private final int fN;
        private final int fPick;
        private final int fExpected;

        private GuessNumberHigherOrLowerTestParameters(int fN, int fPick, int fExpected) {
            this.fN = fN;
            this.fPick = fPick;
            this.fExpected = fExpected;
        }

        public int getN() {
            return fN;
        }

        public int getPick() {
            return fPick;
        }

        public int getExpected() {
            return fExpected;
        }

        static NBuilder getbuilder() {
            return new NBuilder();
        }

        //    Playground for Builder - does not really add great value for such a simple Problem and Test
        static final class NBuilder {
            private NBuilder() {
            }

            PickBuilder withN(int fN) {
                return new PickBuilder(fN);
            }
        }

        static final class PickBuilder {
            private final int fN;

            private PickBuilder(int fN) {
                this.fN = fN;
            }

            ExpectedBuilder withPick(int fPick) {
                return new ExpectedBuilder(fN, fPick);
            }
        }

        static final class ExpectedBuilder {
            private final int fN;
            private final int fPick;

            private ExpectedBuilder(int fN, int fPick) {
                this.fN = fN;
                this.fPick = fPick;
            }

            GuessNumberHigherOrLowerTestParameters buildWithExpected(int fExpected) {
                return new GuessNumberHigherOrLowerTestParameters(fN, fPick, fExpected);
            }
        }
    }

    @Parameterized.Parameters
    public static Collection<GuessNumberHigherOrLowerTestParameters> data() {
        //noinspection unchecked
        return Arrays.asList(
                GuessNumberHigherOrLowerTestParameters.getbuilder().withN(10).withPick(6).buildWithExpected(6),
                GuessNumberHigherOrLowerTestParameters.getbuilder().withN(1).withPick(1).buildWithExpected(1),
                GuessNumberHigherOrLowerTestParameters.getbuilder().withN(2).withPick(1).buildWithExpected(1),
                GuessNumberHigherOrLowerTestParameters.getbuilder().withN(2).withPick(2).buildWithExpected(2),
                GuessNumberHigherOrLowerTestParameters.getbuilder().withN(999999).withPick(39394).buildWithExpected(39394),
                GuessNumberHigherOrLowerTestParameters.getbuilder().withN(2126753390).withPick(1702766719).buildWithExpected(1702766719)
        );
    }

    private final int fN;
    private final int fPick;
    private final int fExpected;

    public GuessNumberHigherOrLowerTest(GuessNumberHigherOrLowerTestParameters guessNumberHigherOrLowerTestParameters) {
//        This method may be nasty and it should be improved
        fN = guessNumberHigherOrLowerTestParameters.fN;
        fPick = guessNumberHigherOrLowerTestParameters.fPick;
        fExpected = guessNumberHigherOrLowerTestParameters.fExpected;
    }

    @Test
    public void shouldGuessNumber() {
        assertEquals(fExpected, new GuessNumberHigherOrLower(fPick).guessNumber(fN));
    }
}