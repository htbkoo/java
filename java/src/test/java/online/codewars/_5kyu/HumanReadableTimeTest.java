package online.codewars._5kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 17 May 2016
 */
public class HumanReadableTimeTest {
    @Test
    public void Tests() {
        assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
        assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
        assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
        assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
        assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
    }
    @Test
    public void LocalTests() {
        assertEquals("makeReadable(61)", "00:01:01", HumanReadableTime.makeReadable(61));
        assertEquals("makeReadable(105)", "00:01:45", HumanReadableTime.makeReadable(105));
        assertEquals("makeReadable(86400)", "24:00:00", HumanReadableTime.makeReadable(86400));
    }
}