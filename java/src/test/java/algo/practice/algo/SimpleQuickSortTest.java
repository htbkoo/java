package algo.practice.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 22/9/15
 */
public class SimpleQuickSortTest {
    SimpleQuickSort simpleQuickSort;

    @Before
    public void setUp() throws Exception {
        simpleQuickSort = new SimpleQuickSort();
    }

    @Test
    public void shoulSortByLomutoPartitionScheme() throws Exception {
        assertEquals(
                Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L),
                simpleQuickSort.inplaceSort(Arrays.asList(2L, 9L, 5L, 7L, 1L, 10L, 4L, 3L, 6L, 8L), SimpleQuickSort.LomutoQuickSortPartitionScheme.createPartitionScheme(), (-1))
        );
    }

    @Test
    public void shoulSortByHoarePartitionScheme() throws Exception {
        assertEquals(
                Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L),
                simpleQuickSort.inplaceSort(Arrays.asList(2L, 9L, 5L, 7L, 1L, 10L, 4L, 3L, 6L, 8L), SimpleQuickSort.HoareQuickSortPartitionScheme.createPartitionScheme(), 0)
        );
    }
}