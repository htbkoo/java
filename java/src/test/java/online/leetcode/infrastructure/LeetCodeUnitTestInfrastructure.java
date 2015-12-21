package online.leetcode.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 7/11/15
 * <p>
 * The unit test infrastructure for the LeetCode problems
 *
 * Update: migrating to composition instead of inheritance
 */
public abstract class LeetCodeUnitTestInfrastructure<E> {
    private static Logger logger = LogManager.getLogger(LeetCodeUnitTestInfrastructure.class);

    private final Class<?> classUnderTest;
    protected final Object fExpected;

    public LeetCodeUnitTestInfrastructure(Class<?> classUnderTest, E fExpected) {
        this.classUnderTest = classUnderTest;
        this.fExpected = fExpected;
    }

    public final void test() {
        test(0);
    }

    public final void test(int methodNum) {
        logger.info(String.format("Triggering test for class %s", classUnderTest.getCanonicalName()));
        final Method methodToBeInvoked = classUnderTest.getMethods()[methodNum];
        logger.info(String.format("and the %sth method to be invoked is %s ", methodNum + 1, methodToBeInvoked.getName()));
        try {
            assertEquals(fExpected, methodToBeInvoked.invoke(classUnderTest.cast(classUnderTest.newInstance()), getFInput()));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(String.format("Exception %s caught during the test for %s", e.getMessage(), classUnderTest.getCanonicalName()), e);
        }
    }

    protected abstract Object getFInput();

    public static Class<?> getClassUnderTest(Class<?> testClazz) throws ClassNotFoundException {
        return Class.forName(testClazz.getName().replaceAll("Test", ""));
    }
}
