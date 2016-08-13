package online.codewars._6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 13 Aug 2016
 */
public class DuplicateEncoderTest {
    @Test
    public void test() {
        assertEquals(")()())()(()()(", DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))", DuplicateEncoder.encode("   ()(   "));
    }
}