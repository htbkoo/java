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
                new BinaryHeapTestCase(asList(3, 4, 2), asList(2, 3, 4))
        );
    }

    @Theory
    public void should_be_able_to_insert_3_items_and_sort_and_pop_from_a_heap_of_integer(@FromDataPoints("insertAndPopTestCases") BinaryHeapTestCase testCase) {
        //        given
        Heap<Integer> integerHeap = new BinaryHeap<>();

        //        when
        testCase.givenItems.forEach(integerHeap::insert);

        //        then
        testCase.expectedItems.forEach(i -> assertThat(integerHeap.pop()).isEqualTo(i));
    }

    @Test
    public void should_be_able_to_peek_from_a_heap_of_integer() {
        //        given
        Heap<Integer> integerHeap = new BinaryHeap<>();
        final List<Integer> givenItems = asList(3, 4, 1);

        //        when
        givenItems.forEach(integerHeap::insert);

        //        then
        assertThat(integerHeap.peek()).isEqualTo(1);
        assertThat(integerHeap.peek()).isEqualTo(1);
    }

    private static class BinaryHeapTestCase {
        final List<Integer> givenItems, expectedItems;

        private BinaryHeapTestCase(List<Integer> givenItems, List<Integer> expectedItems) {
            this.givenItems = givenItems;
            this.expectedItems = expectedItems;
        }
    }
}