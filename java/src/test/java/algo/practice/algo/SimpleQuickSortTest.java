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
                Arrays.asList(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l),
                simpleQuickSort.inplaceSort(Arrays.asList(2l, 9l, 5l, 7l, 1l, 10l, 4l, 3l, 6l, 8l), SimpleQuickSort.LomutoQuickSortPartitionScheme.createPartitionScheme(), (-1))
        );
    }

    @Test
    public void shoulSortByHoarePartitionScheme() throws Exception {
        assertEquals(
                Arrays.asList(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l),
                simpleQuickSort.inplaceSort(Arrays.asList(2l, 9l, 5l, 7l, 1l, 10l, 4l, 3l, 6l, 8l), SimpleQuickSort.HoareQuickSortPartitionScheme.createPartitionScheme(), 0)
        );
    }
}