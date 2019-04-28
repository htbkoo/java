package interview.practice;

import java.util.HashSet;
import java.util.Set;

public class RangeMerger {
    Set<Long> set = new HashSet<>();

    public void put(long id) {
        set.add(id);
    }

    public boolean contains(long id) {
        return set.contains(id);
    }

    public int size() {
        return set.size();
    }
}
