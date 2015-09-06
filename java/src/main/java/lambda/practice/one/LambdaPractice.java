package lambda.practice.one;

import com.google.common.collect.*;

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
public class LambdaPractice {
    public String getLambdaResult() {
        String a = "a";
        Function<String, String> b = s -> s;
        return b.apply(a);
    }

    public Map transformList(List<Object> list) {

        return Maps.asMap(Sets.newHashSet(list), o -> o + "_value");
    }

    public <K, V> Multimap<K, V> transformListAsValue(List<V> list, Function<V, K> keyGenerator) {
        Multimap<K, V> map = ArrayListMultimap.create();
        for (V v : list) {
            K k = keyGenerator.apply(v);
//            if (!map.containsKey(k)) {
            map.put(k, v);
//            }else{
//                throw new IllegalArgumentException("M");
//            }
        }
        return map;
    }
}
