package algo.practice.utils;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 15/9/15
 */
public class SimpleMinBinaryHeapTest {
    @Test
    public void shouldBuildHeap() throws Exception {
        SimpleMinBinaryHeap<Integer> simpleMinBinaryHeap = new SimpleMinBinaryHeap<>(1);
        assertEquals((Integer) 1, simpleMinBinaryHeap.peek());
        assertEquals(1, simpleMinBinaryHeap.size());
    }

    @Test
    public void shouldGetMinInHeap() throws Exception {
        SimpleMinBinaryHeap<Integer> simpleMinBinaryHeap = new SimpleMinBinaryHeap<>();
        simpleMinBinaryHeap.push(5);
        simpleMinBinaryHeap.push(3);
        simpleMinBinaryHeap.push(2);
        simpleMinBinaryHeap.push(2);
        simpleMinBinaryHeap.push(1);
        simpleMinBinaryHeap.push(4);

        assertEquals((Integer) 1, simpleMinBinaryHeap.peek());
        assertEquals(6, simpleMinBinaryHeap.size());
    }

    @Ignore
    @Test
    public void shouldPopMinInHeap() throws Exception {
        SimpleMinBinaryHeap<Integer> simpleMinBinaryHeap = new SimpleMinBinaryHeap<>();
        simpleMinBinaryHeap.push(5);
        simpleMinBinaryHeap.push(3);
        simpleMinBinaryHeap.push(2);
        simpleMinBinaryHeap.push(2);
        simpleMinBinaryHeap.push(1);
        simpleMinBinaryHeap.push(4);

        assertEquals((Integer) 1, simpleMinBinaryHeap.pop());
        assertEquals(5, simpleMinBinaryHeap.size());
        assertEquals((Integer) 2, simpleMinBinaryHeap.pop());
        assertEquals(4, simpleMinBinaryHeap.size());
        assertEquals((Integer) 2, simpleMinBinaryHeap.pop());
        assertEquals(3, simpleMinBinaryHeap.size());
    }

    @Test
    public void shouldTestPerformanceInBuildingHeap() throws Exception {
        SimpleMinBinaryHeap<Integer> simpleMinBinaryHeap = new SimpleMinBinaryHeap<>();
        simpleMinBinaryHeap.push(5);
        simpleMinBinaryHeap.push(3);
        simpleMinBinaryHeap.push(2);
        simpleMinBinaryHeap.push(2);
        simpleMinBinaryHeap.push(1);
        simpleMinBinaryHeap.push(4);

        assertEquals((Integer) 1, simpleMinBinaryHeap.peek());
        assertEquals(6, simpleMinBinaryHeap.size());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfPeekEmptyHeap() throws Exception {
        SimpleMinBinaryHeap simpleMinBinaryHeap = new SimpleMinBinaryHeap<>();
        assertEquals(0, simpleMinBinaryHeap.size());

        try {
            simpleMinBinaryHeap.peek();
        } catch (IllegalStateException e) {
            assertEquals("Heap is Empty", e.getMessage());
            throw e;
        }
    }
}