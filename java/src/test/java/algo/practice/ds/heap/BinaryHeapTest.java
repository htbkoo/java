package algo.practice.ds.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryHeapTest {
    @Test
    public void should_be_able_to_insert_into_and_pop_from_a_heap_of_integer() {
        //        given
        Heap<Integer> integerHeap = new BinaryHeap<>();
        final int givenItem = 0;

        //        when
        integerHeap.insert(givenItem);

        //        then
        Integer actual = integerHeap.pop();
        assertThat(actual).isEqualTo(givenItem);
    }

    @Test
    public void should_be_able_to_insert_3_items_and_sort_and_pop_from_a_heap_of_integer() {
        //        given
        Heap<Integer> integerHeap = new BinaryHeap<>();
        final List<Integer> givenItems = Arrays.asList(3, 4, 2);

        //        when
        givenItems.forEach(integerHeap::insert);

        //        then
        final List<Integer> expectedItems = Arrays.asList(2, 3, 4);
        expectedItems.forEach(i -> assertThat(integerHeap.pop()).isEqualTo(i));
    }
}