package algo.practice.algo;

import java.util.List;

/**
 * Created by Hey on 22/9/15
 * <p>
 * ---------------------------
 * <p>
 * Just a simple quick sort implementation - practise and see how fast I can implement a quick sort
 * <p>
 * May end up in bad structure so do not expect too much.
 */
public class SimpleQuickSort {

    private interface SimpleQuickSortPartitionScheme {
        int partition(List<Long> longs, int lo, int hi);
    }

    public static class HoareQuickSortPartitionScheme implements SimpleQuickSortPartitionScheme {
        private static HoareQuickSortPartitionScheme hoareQuickSortPartitionSchemeSingleton;

        private HoareQuickSortPartitionScheme() {
        }

        public static SimpleQuickSortPartitionScheme createPartitionScheme() {
            if (hoareQuickSortPartitionSchemeSingleton == null) {
                hoareQuickSortPartitionSchemeSingleton = new HoareQuickSortPartitionScheme();
            }
            return hoareQuickSortPartitionSchemeSingleton;
        }

        @Override
        public int partition(List<Long> longs, int lo, int hi) {
            Long pivot = longs.get(lo);
            int i = lo - 1;
            int j = hi + 1;
            while (true) {
                do {
                    j = j - 1;
                } while (longs.get(j) > pivot);
                do {
                    i = i + 1;
                } while (longs.get(i) < pivot);
                if (i < j) {
                    Long iValue = longs.get(i);
                    Long jValue = longs.get(j);
                    longs.set(i, jValue);
                    longs.set(j, iValue);
                } else {
                    return j;
                }
            }
        }
    }

    public static class LomutoQuickSortPartitionScheme implements SimpleQuickSortPartitionScheme {
        private static LomutoQuickSortPartitionScheme lomutoQuickSortPartitionSchemeSingleton;

        private LomutoQuickSortPartitionScheme() {
        }

        public static LomutoQuickSortPartitionScheme createPartitionScheme() {
            if (lomutoQuickSortPartitionSchemeSingleton == null) {
                lomutoQuickSortPartitionSchemeSingleton = new LomutoQuickSortPartitionScheme();
            }
            return lomutoQuickSortPartitionSchemeSingleton;
        }

        @Override
        public int partition(List<Long> longs, int lo, int hi) {
            Long pivot = longs.get(hi);
            int i = lo; // place for swapping;
            for (int j = lo; j <= hi - 1; j++) {
                Long curr = longs.get(j);
                if (curr <= pivot) {
                    longs.set(j, longs.get(i));
                    longs.set(i, curr);
                    i++;
                }
            }

            longs.set(hi, longs.get(i));
            longs.set(i, pivot);

            return i;
        }
    }

    public List<Long> inplaceSort(List<Long> longs, SimpleQuickSortPartitionScheme scheme, int lowerHalfHiAdjustment) {
        quickSort(longs, 0, longs.size() - 1, scheme, lowerHalfHiAdjustment);
        return longs;
    }

    //    Note that the list is mutable, can perform in place sort directly
    private void quickSort(List<Long> longs, int lo, int hi, SimpleQuickSortPartitionScheme scheme, int lowerHalfHiAdjustment) {
        if (lo < hi) {
            int p = scheme.partition(longs, lo, hi);
            quickSort(longs, lo, p + lowerHalfHiAdjustment, scheme, lowerHalfHiAdjustment);
            quickSort(longs, p + 1, hi, scheme, lowerHalfHiAdjustment);
        }
    }

}
