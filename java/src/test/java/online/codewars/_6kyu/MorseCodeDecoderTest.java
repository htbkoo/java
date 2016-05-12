package online.codewars._6kyu;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Hey on 12 May 2016.
 *
 * ---
 *
 * Unit test for DecodeTheMorseCode
 */
public class MorseCodeDecoderTest {

    @Test
    public void testExampleFromDescription() {
        assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
    }

    @Test
    public void shouldDecodeForMoreThanOneConsecutiveSpaces() throws Exception {
        assertThat(MorseCodeDecoder.decode(".... . -.--     .--- ..- -.. ."), is("HEY  JUDE"));
        assertThat(MorseCodeDecoder.decode(".... . -.--       .--- ..- -.. ."), is("HEY   JUDE"));
        assertThat(MorseCodeDecoder.decode(".... . -.--         .--- ..- -.. ."), is("HEY    JUDE"));
    }
}