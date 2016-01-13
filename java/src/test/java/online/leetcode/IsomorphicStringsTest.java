package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 13/1/16
 */
@RunWith(Parameterized.class)
public class IsomorphicStringsTest {
    private enum ParameterType {
        S, T, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "",
                        ParameterType.T, "",
                        ParameterType.ANSWER, TRUE
                )},
                /*
//                Accroding to assumption, "You may assume both s and t have the same length."
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "a",
                        ParameterType.T, "ab",
                        ParameterType.ANSWER, FALSE
                )},
                */
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "egg",
                        ParameterType.T, "add",
                        ParameterType.ANSWER, TRUE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "paper",
                        ParameterType.T, "title",
                        ParameterType.ANSWER, TRUE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "aa",
                        ParameterType.T, "bb",
                        ParameterType.ANSWER, TRUE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "ab",
                        ParameterType.T, "aa",
                        ParameterType.ANSWER, FALSE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "foo",
                        ParameterType.T, "bar",
                        ParameterType.ANSWER, FALSE
                )});
    }

    private String fInputS;
    private String fInputT;
    private boolean fExpected;

    public IsomorphicStringsTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputS = (String) parametersMap.get(ParameterType.S);
        fInputT = (String) parametersMap.get(ParameterType.T);
        fExpected = (boolean) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldCheckIsIsomorphic() {
            assertEquals(fExpected, new IsomorphicStrings().isIsomorphic(fInputS, fInputT));
    }

}