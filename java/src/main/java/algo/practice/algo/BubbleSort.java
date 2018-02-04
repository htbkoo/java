package algo.practice.algo;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static <X extends Comparable<? super X>> List<X> bubbleSort(List<X> list) {
        final List<X> copy = new ArrayList<>(list);

        final int length = copy.size();
        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - 1 - i; ++j) {
                final X curr = copy.get(j), next = copy.get(j + 1);
                if (curr.compareTo(next) > 0) {
                    copy.set(j, next);
                    copy.set(j + 1, curr);
                }
            }
        }

        return copy;
    }
}
