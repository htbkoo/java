package common.test.utils;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Created by Hey on 23/9/15
 *
 * ---------------------------
 *
 * A very simple testing timer using JodaTime instant to time before and after the method invocation, which is done by
 * the ReflectionTestUtils from Spring testing framework
 *
 */
public class SimpleTestingTimer {
    public final static class SimpleTestingTimerResult<T> {
        private T returnValue;
        private long timeNeeded;

        public SimpleTestingTimerResult(T returnValue, long timeNeeded) {
            this.returnValue = returnValue;
            this.timeNeeded = timeNeeded;
        }

        public long getTimeNeeded() {
            return timeNeeded;
        }

        public T getReturnValue() {
            return returnValue;
        }

    }

    public static <T> SimpleTestingTimerResult<T> time(Object target, String methodName, Object... args) {
        Instant before = new DateTime().toInstant();
        T returnValue = ReflectionTestUtils.<T>invokeMethod(target, methodName, args);
        Instant after = new DateTime().toInstant();

        return new SimpleTestingTimerResult<>(returnValue, after.getMillis() - before.getMillis());
    }

}
