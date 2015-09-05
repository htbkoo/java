package lambda.practice.one;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by Hei on 03/09/2015.
 * <p>
 * ------------------------------------
 * <p>
 * A practice for java 8 lambda expression
 */
public class Practice {
    public String getLambdaResult() {
        String a = "a";
        Function<String, String> b = s -> s;
        return b.apply(a);
    }

    public Map transformList(List<Object> list) {
        return Maps.asMap(Sets.newHashSet(list), o -> o);
    }
}
