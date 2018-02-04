package algo.practice.algo;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static algo.practice.algo.BubbleSort.bubbleSort;
import static com.google.common.collect.ImmutableList.of;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Theories.class)
public class BubbleSortTest {
    @DataPoints("sortTestCases")
    public static List<BubbleSortTestCase> insertAndPopTestCases() {
        return of(
                new BubbleSortTestCase(of(), of()),
                new BubbleSortTestCase(of(1), of(1)),
                new BubbleSortTestCase(of(3, 4, 2), of(2, 3, 4)),
                new BubbleSortTestCase(of(3, 4, 2, 1, 8, 5, 7, 6), of(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }

    @Theory
    public void should_be_able_to_insert_and_pop_from_a_heap_of_integer(@FromDataPoints("sortTestCases") BubbleSortTestCase testCase) {
        //        when
        List<Integer> actual = bubbleSort(testCase.givenItems);

        //        then
        assertThat(actual).isEqualTo(testCase.expectedItems);
    }

    private static class BubbleSortTestCase {
        final List<Integer> givenItems, expectedItems;

        private BubbleSortTestCase(List<Integer> givenItems, List<Integer> expectedItems) {
            this.givenItems = givenItems;
            this.expectedItems = expectedItems;
        }
    }
}