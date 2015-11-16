package online.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Hey on 7/11/15
 * <p>
 * The unit test infrastructure for the LeetCode problems
 *
 * Update: migrating to composition instead of inheritance
 */
public final class LeetCodeUnitTestInfrastructureForOneInput<L,R> extends LeetCodeUnitTestInfrastructure<R> {
    private static Logger logger = LogManager.getLogger(LeetCodeUnitTestInfrastructureForOneInput.class);

    protected final L fInput;

    private LeetCodeUnitTestInfrastructureForOneInput(Class<?> classUnderTest, L fInput, R fExpected) {
        super(classUnderTest, fExpected);
        this.fInput = fInput;
    }

    public static <L,R> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithInput(Class<?> classUnderTest, Pair<L, R> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, inputExpectedPair.getLeft(), inputExpectedPair.getRight());
    }

    public static <L,R> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithListOfInteger(Class<?> classUnderTest, Pair<Integer[], R> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, ArrayUtils.toPrimitive(inputExpectedPair.getLeft()), inputExpectedPair.getRight());
    }

     public static <L,R> LeetCodeUnitTestInfrastructureForOneInput createLeetCodeUnitTestPairInfrastructureWithListOfCharacter(Class<?> classUnderTest, Pair<Character[], R> inputExpectedPair) {
        return new LeetCodeUnitTestInfrastructureForOneInput<>(classUnderTest, ArrayUtils.toPrimitive(inputExpectedPair.getLeft()), inputExpectedPair.getRight());
    }

    @Override
    protected L getFInput(){
        return fInput;
    }
}
