package stream.practice.one;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hey on 6/9/15.
 */
public class StreamPractice {
    private static Logger logger = LogManager.getLogger(StreamPractice.class);

    private Map<String, List<String>> map(List<String> docList) {
        Supplier<Stream<String>> streamSupplier = docList::stream;
//        streamSupplier.get().map(String::trim).flatMap(s -> Lists.newArrayList(s.split("\\s+")).stream()).forEach(logger::debug);
        streamSupplier.get().map(String::trim).map(s -> s.replaceAll("[^a-zA-Z ]", "")).flatMap(s -> Lists.newArrayList(s.split("\\s+")).stream()).forEach(logger::debug);

        return streamSupplier.get()
        .map(String::trim)
                .map(s -> s.replaceAll("[^a-zA-Z ]", ""))
                .flatMap(s -> Lists.newArrayList(s.split("\\s+")).stream())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s));
    }

    private Map<String, Integer> reduce(Map<String, List<String>> map) {
        Map<String, Integer> output = Maps.newHashMap();
        map.forEach((k, v) -> output.put(k, v.size()));
        return output;
    }

    public Map<String, Integer> wordCount(String... docs) {
        List<String> docList = Lists.newArrayList(docs);
        return reduce(map(docList));
    }
}
