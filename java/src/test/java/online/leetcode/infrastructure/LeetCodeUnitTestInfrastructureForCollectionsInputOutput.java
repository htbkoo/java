package online.leetcode.infrastructure;

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
 * Created by Hey on 20/1/16
 * <p>
 * The unit test infrastructure for the LeetCode problems
 * <p>
 * Update: migrating to composition instead of inheritance
 */
public class LeetCodeUnitTestInfrastructureForCollectionsInputOutput<L, R> extends LeetCodeUnitTestInfrastructure<Collection<? extends R>> {
    private static Logger logger = LogManager.getLogger(LeetCodeUnitTestInfrastructureForCollectionsInputOutput.class);
    protected final Collection<? extends L> fInput;

    private LeetCodeUnitTestInfrastructureForCollectionsInputOutput(Class<?> classUnderTest, Collection<? extends L> fInput, Collection<? extends R> fExpected) {
        super(classUnderTest, fExpected);
        this.fInput = fInput;
    }

    public static <L, R> LeetCodeUnitTestInfrastructureForCollectionsInputOutput createWithAssertionConsideringOrder(Class<?> classUnderTest, Pair<Collection<? extends L>, Collection<? extends R>> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForCollectionsInputOutput<>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight());
    }

//    <T extends Comparable<? super T>>
//    <? extends Comparable<?>>

    public static <T extends Comparable<? super T>> LeetCodeUnitTestInfrastructureForCollectionsInputOutput createWithAssertionIgnoringOrder(Class<?> classUnderTest, Pair<Collection<? extends T>, Collection<? extends T>> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForCollectionsInputOutput<T, T>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight()) {
            @Override
            protected void assertExpectedEqualsToResult(Collection<? extends T> expected, Object returnValue) {
                if (!(returnValue instanceof Collection)) {
                    assertEquals(expected, returnValue);
                }
                try {
                    final List<T> expectedInList = new ArrayList<>(expected);
                    //noinspection unchecked,ConstantConditions  // Caught to give a more meaningful error message to user
                    final List<T> returnValueInList = new ArrayList<>((Collection<? extends T>) returnValue);
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
    protected void assertExpectedEqualsToResult(Collection<? extends R> expected, Object returnValue) {
        assertEquals(expected, returnValue);
    }

    @Override
    protected Collection<? extends L> getFInput() {
        return fInput;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
