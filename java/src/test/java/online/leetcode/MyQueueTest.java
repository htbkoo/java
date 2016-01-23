package online.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Hey on 23/11/15
 */
public class MyQueueTest {
    MyQueue myQueue;
    Deque<Integer> controlQueue;

    @Before
    public void setUp() throws Exception {
        myQueue = new MyQueue();
        controlQueue = new ArrayDeque<>();
        assertTrue(myQueue.empty());
        assertTrue(controlQueue.isEmpty());
    }

    @Test
    public void shouldBeSameAsQueueForEmptyCheckAndAddAndPeek() throws Exception {
        myQueue.push(1);
        controlQueue.add(1);

        assertEquals(1, myQueue.peek());
        assertEquals(1, (int)controlQueue.peek());
    }

    @Test
    public void shouldBeSameAsQueueForMultipleAddAndPeekAndPoll() throws Exception {
        myQueue.push(1);
        controlQueue.add(1);

        myQueue.push(2);
        controlQueue.add(2);

        assertEquals(1, myQueue.peek());
        assertEquals(1, (int) controlQueue.peek());

        myQueue.pop();
        controlQueue.poll();

        assertEquals(2, myQueue.peek());
        assertEquals(2, (int) controlQueue.peek());

        myQueue.push(3);
        controlQueue.add(3);

        assertEquals(2, myQueue.peek());
        assertEquals(2, (int) controlQueue.peek());

        myQueue.pop();
        controlQueue.poll();

        assertEquals(3, myQueue.peek());
        assertEquals(3, (int) controlQueue.peek());

        myQueue.push(5);
        controlQueue.add(5);

        myQueue.push(6);
        controlQueue.add(6);

        assertEquals(3, myQueue.peek());
        assertEquals(3, (int) controlQueue.peek());

        myQueue.pop();
        controlQueue.poll();

        assertEquals(5, myQueue.peek());
        assertEquals(5, (int) controlQueue.peek());

        myQueue.pop();
        controlQueue.poll();

        assertEquals(6, myQueue.peek());
        assertEquals(6, (int) controlQueue.peek());

        myQueue.pop();
        controlQueue.poll();

        assertTrue(myQueue.empty());
        assertTrue(controlQueue.isEmpty());
    }
}