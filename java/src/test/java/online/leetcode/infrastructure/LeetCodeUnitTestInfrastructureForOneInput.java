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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Hey on 7/11/15
 * <p>
 * The unit test infrastructure for the LeetCode problems
 * <p>
 * Update: migrating to composition instead of inheritance
 */
public class LeetCodeUnitTestInfrastructureForOneInput<I, E> extends LeetCodeUnitTestInfrastructure<E> {
    private static Logger logger = LogManager.getLogger(LeetCodeUnitTestInfrastructureForOneInput.class);

    protected final I fInput;

    private LeetCodeUnitTestInfrastructureForOneInput(Class<?> classUnderTest, I fInput, E fExpected) {
        super(classUnderTest, fExpected);
        this.fInput = fInput;
    }

    public static <I, E> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithInput(Class<?> classUnderTest, Pair<I, E> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight());
    }

    public static <E> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithListOfInteger(Class<?> classUnderTest, Pair<Integer[], E> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, ArrayUtils.toPrimitive(inputExpectedPair.getLeft()), inputExpectedPair.getRight());
    }

    public static <E> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithListOfCharacter(Class<?> classUnderTest, Pair<Character[], E> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, ArrayUtils.toPrimitive(inputExpectedPair.getLeft()), inputExpectedPair.getRight());
    }

    public static <I, E extends Comparable<? super E>> LeetCodeUnitTestInfrastructureForOneInput createWithAssertionIgnoringOrder(Class<?> classUnderTest, Pair<I, Collection<? extends E>> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<I, Collection<? extends E>>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight()) {
            @Override
            protected void assertExpectedEqualsToResult(Collection<? extends E> expected, Object returnValue) {
                if (!(returnValue instanceof Collection)) {
                    assertEquals(expected, returnValue);
                }
                try {
                    final List<E> expectedInList = new ArrayList<>(expected);
                    //noinspection unchecked,ConstantConditions  // Caught to give a more meaningful error message to user
                    final List<E> returnValueInList = new ArrayList<>((Collection<? extends E>) returnValue);
                    Collections.sort(expectedInList);
                    Collections.sort(returnValueInList);
                    assertEquals(expectedInList, returnValueInList);
                } catch (ClassCastException e) {
                    fail(String.format("Return Value (%s) is not a Collection and thus would be different from expected (%s).", returnValue.toString(), Arrays.toString(expected.toArray())));
                }
            }
        };
    }

    public static <I, E> LeetCodeUnitTestInfrastructureForOneInput createWithExistenceAssertion(Class<?> classUnderTest, Pair<I, ? extends Collection<? extends E>> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<Object, Collection<? extends E>>(classUnderTest, ArrayUtils.toPrimitive((Integer[]) inputExpectedPair.getLeft()), inputExpectedPair.getRight()) {
            @Override
            protected void assertExpectedEqualsToResult(Collection<? extends E> expected, Object returnValue) {
                try {
                    //noinspection unchecked // Checked by catching ClassCastException
                    E castedReturnValue = (E) returnValue;
                    assertTrue("The expected does not contain the return value!",expected.contains(castedReturnValue));
                }catch (ClassCastException e){
                    fail(String.format("The type of Return Value is %s which does not match the expected type!", returnValue.getClass().getSimpleName()));
                }
            }
        };
    }

    @Override
    protected I getFInput() {
        return fInput;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected void assertExpectedEqualsToResult(E expected, Object returnValue) {
        assertEquals(expected, returnValue);
    }

}
