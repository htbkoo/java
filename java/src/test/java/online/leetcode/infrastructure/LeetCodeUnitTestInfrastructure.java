package online.leetcode.infrastructure;

import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Hey on 7/11/15
 * <p>
 * The unit test infrastructure for the LeetCode problems
 *
 * Update: migrating to composition instead of inheritance
 */
public abstract class LeetCodeUnitTestInfrastructure<E> {
    private final Class<?> classUnderTest;
    private final E fExpected;

    public LeetCodeUnitTestInfrastructure(Class<?> classUnderTest, E fExpected) {
        this.classUnderTest = classUnderTest;
        this.fExpected = fExpected;
    }

    public final void test() {
        test(0);
    }

    public final void test(int methodNum) {
        getLogger().info(String.format("Triggering test for class %s", classUnderTest.getCanonicalName()));
        final Method methodToBeInvoked = classUnderTest.getMethods()[methodNum];
        getLogger().info(String.format("and the %sth method to be invoked is %s ", methodNum + 1, methodToBeInvoked.getName()));
        try {
            final Object fReturnValue = methodToBeInvoked.invoke(classUnderTest.cast(classUnderTest.newInstance()), getFInput());
            assertExpectedEqualsToResult(fExpected, fReturnValue);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(String.format("Exception %s caught during the test for %s", e.getMessage(), classUnderTest.getCanonicalName()), e);
        }
    }

    protected abstract void assertExpectedEqualsToResult(E expected, Object returnValue);
    protected abstract Object getFInput();
    protected abstract Logger getLogger();

    public static Class<?> getClassUnderTest(Class<?> testClazz) throws ClassNotFoundException {
        return Class.forName(testClazz.getName().replaceAll("Test", ""));
    }
}
