package algo.practice.ds.heap;

import org.junit.Test;

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
}