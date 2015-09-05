package lambda.practice.one;

import java.util.function.Function;

/**
 * Created by Hei on 03/09/2015.
 *
 * ------------------------------------
 *
 * A practice for java 8 lambda expression
 */
public class Practice {
    public String getLambdaResult() {
        String a = "a";
        Function<String, String> b = s -> s;
        return b.apply(a);
    }
}
