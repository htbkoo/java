package online.leetcode.infrastructure;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Hey on 7/11/15
 * <p>
 * The unit test infrastructure for the LeetCode problems
 * <p>
 * Update: migrating to composition instead of inheritance
 */
public class LeetCodeUnitTestInfrastructureForOneInput<L, R> extends LeetCodeUnitTestInfrastructure<R> {
    private static Logger logger = LogManager.getLogger(LeetCodeUnitTestInfrastructureForOneInput.class);

    protected final L fInput;

    private LeetCodeUnitTestInfrastructureForOneInput(Class<?> classUnderTest, L fInput, R fExpected) {
        super(classUnderTest, fExpected);
        this.fInput = fInput;
    }

    public static <L, R> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithInput(Class<?> classUnderTest, Pair<L, R> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight());
    }

    public static <R> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithListOfInteger(Class<?> classUnderTest, Pair<Integer[], R> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, ArrayUtils.toPrimitive(inputExpectedPair.getLeft()), inputExpectedPair.getRight());
    }

    public static <R> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithListOfCharacter(Class<?> classUnderTest, Pair<Character[], R> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, ArrayUtils.toPrimitive(inputExpectedPair.getLeft()), inputExpectedPair.getRight());
    }

    public static <L, R extends Comparable<? super R>> LeetCodeUnitTestInfrastructureForOneInput createWithAssertionIgnoringOrder(Class<?> classUnderTest, Pair<L, Collection<? extends R>> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<L, Collection<? extends R>>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight()) {
            @Override
            protected void assertExpectedEqualsToResult(Collection<? extends R> expected, Object returnValue) {
                if (!(returnValue instanceof Collection)) {
                    assertEquals(expected, returnValue);
                }
                try {
                    final List<R> expectedInList = new ArrayList<>(expected);
                    //noinspection unchecked,ConstantConditions  // Caught to give a more meaningful error message to user
                    final List<R> returnValueInList = new ArrayList<>((Collection<? extends R>) returnValue);
                    Collections.sort(expectedInList);
                    Collections.sort(returnValueInList);
                    assertEquals(expectedInList, returnValueInList);
                } catch (ClassCastException e) {
                    fail(String.format("Return Value (%s) is not a Collection and thus would be different from expected (%s).", returnValue.toString(), Arrays.toString(expected.toArray())));
                }
            }
        };
    }

    @Override
    protected L getFInput() {
        return fInput;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected void assertExpectedEqualsToResult(R expected, Object returnValue) {
        assertEquals(expected, returnValue);
    }

}
