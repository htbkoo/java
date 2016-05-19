package online.codewars._6kyu;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 16 May 2016
 */
public class WhichAreInTest {
    @Test
    public void test1() {
        String a[] = new String[]{"arp", "live", "strong"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String r[] = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }

    @Test
    public void test2() {
        String a[] = new String[]{"tarp", "mice", "bull"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String r[] = new String[]{};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }

    @Test
    public void customTest() {
        String a[] = new String[]{"tarp"};
        String b[] = new String[]{};
        String r[] = new String[]{};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void caseSensitiveTest() {
        String a[] = new String[]{"arp"};
        String b[] = new String[]{"TARP"};
        String r[] = new String[]{};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
}