package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class CompareVersionNumbersTest {
    private enum ParameterType {
        VERSION1, VERSION2, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "0.1",
                        ParameterType.VERSION2, "0.1",
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "0.1",
                        ParameterType.VERSION2, "1.1",
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "1.2",
                        ParameterType.VERSION2, "1.1",
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "13.37",
                        ParameterType.VERSION2, "13.37.1",
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "13.37",
                        ParameterType.VERSION2, "13.36.1",
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "1",
                        ParameterType.VERSION2, "0",
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "1234567",
                        ParameterType.VERSION2, "1234566",
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "1234567.123.234.5",
                        ParameterType.VERSION2, "1234566.123.234.5",
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "1234567.123.234.5",
                        ParameterType.VERSION2, "1234567.123.234.56789",
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.VERSION1, "1.0",
                        ParameterType.VERSION2, "1",
                        ParameterType.ANSWER, 0
                )});
    }

    private String fInputVersion1;
    private String fInputVersion2;
    private int fExpected;

    public CompareVersionNumbersTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputVersion1 = (String) parametersMap.get(ParameterType.VERSION1);
        fInputVersion2 = (String) parametersMap.get(ParameterType.VERSION2);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldCompareVersion() {
        assertEquals(fExpected, new CompareVersionNumbers().compareVersion(fInputVersion1, fInputVersion2));
    }

}