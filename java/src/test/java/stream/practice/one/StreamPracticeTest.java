package stream.practice.one;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 6/9/15.
 * <p>
 * -----------------------------
 */
public class StreamPracticeTest {
    StreamPractice streamPractice;

    @Before
    public void setUp() throws Exception {
        streamPractice = new StreamPractice();
    }

    @Test
    public void shouldBuildWordCountFromMultipleStrings() throws Exception {
//        Copied from Stackoverflow tour in help - http://stackoverflow.com/tour
        String doc1 = "Stack Overflow is a question and answer site for professional and enthusiast programmers. It's built " +
                "and run by you as part of the Stack Exchange network of Q&A sites. With your help, we're working together to " +
                "build a library of detailed answers to every question about programming.";

        String doc2 = "Ask questions, get answers, no distractions. This site is all about getting answers. It's not a discussion " +
                "forum. There's no chit-chat.";

        String doc3 = "The person who asked can mark one answer as \"accepted\". Accepting doesn't mean it's the best answer, it just means that it worked for the person who asked.";

        String testDoc = "I am testing, i am going to continue?";
        String testDoc2 = "I am testing, - i";

        Map<String, Integer> expectedMap = Maps.newHashMap();
        Map<String, Integer> testExpectedMap = Maps.newHashMap();
        testExpectedMap.put("i", 4);
        testExpectedMap.put("am", 3);
        testExpectedMap.put("testing", 2);
        testExpectedMap.put("going", 1);
        testExpectedMap.put("to", 1);
        testExpectedMap.put("continue", 1);

        assertEquals(testExpectedMap, streamPractice.wordCount(testDoc, testDoc2));

//        assertEquals(expectedMap, streamPractice.wordCount(doc1, doc2, doc3));
    }
}