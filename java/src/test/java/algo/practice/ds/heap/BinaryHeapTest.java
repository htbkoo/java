package algo.practice.ds.heap;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Theories.class)
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

    @DataPoints("insertAndPopTestCases")
    public static List<BinaryHeapTestCase> insertAndPopTestCases() {
        return of(
                new BinaryHeapTestCase(of(), of()),
                new BinaryHeapTestCase(of(1), of(1)),
                new BinaryHeapTestCase(of(3, 4, 2), of(2, 3, 4)),
                new BinaryHeapTestCase(of(3, 4, 2, 1, 8, 5, 7, 6), of(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }

    @Theory
    public void should_be_able_to_insert_and_pop_from_a_heap_of_integer(@FromDataPoints("insertAndPopTestCases") BinaryHeapTestCase testCase) {
        //        when
        Heap<Integer> integerHeap = fromList(testCase.givenItems);

        //        then
        testCase.expectedItems.forEach(i -> assertThat(integerHeap.pop()).isEqualTo(i));
    }

    @Test
    public void should_be_able_to_peek_from_a_heap_of_integer() {
        Heap<Integer> integerHeap = fromList(asList(3, 4, 1));

        //        then
        assertThat(integerHeap.peek()).isEqualTo(1);
        assertThat(integerHeap.peek()).isEqualTo(1);
    }

    @Test (expected = IllegalStateException.class)
    public void should_thrown_exception_to_peek_from_an_empty_heap_of_integer() {
        Heap<Integer> integerHeap = new BinaryHeap<>();

        //        then
        integerHeap.peek();
    }

    @Test (expected = IllegalStateException.class)
    public void should_thrown_exception_to_pop_from_an_empty_heap_of_integer() {
        Heap<Integer> integerHeap = new BinaryHeap<>();

        //        then
        integerHeap.pop();
    }

    @DataPoints("sizeTestCases")
    public static List<List<Integer>> sizeTestCases() {
        return of(
                of(),
                of(1),
                of(3, 4, 2),
                of(3, 4, 2, 1, 8, 5, 7, 6)
        );
    }

    @Theory
    public void should_return_size_of_heap(@FromDataPoints("sizeTestCases") List<Integer> list) {
        //        when
        final Heap<Integer> heap = fromList(list);

        //        then
        final int expectedSize = list.size();
        assertThat(heap.size()).isEqualTo(expectedSize);

    }

    private <X extends Comparable<? super X>> Heap<X> fromList(List<? extends X> list) {
        Heap<X> heap = new BinaryHeap<>();
        list.forEach(heap::insert);
        return heap;
    }

    private static class BinaryHeapTestCase {
        final List<Integer> givenItems, expectedItems;

        private BinaryHeapTestCase(List<Integer> givenItems, List<Integer> expectedItems) {
            this.givenItems = givenItems;
            this.expectedItems = expectedItems;
        }
    }
}