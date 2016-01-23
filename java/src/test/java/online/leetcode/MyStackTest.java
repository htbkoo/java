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
public class MyStackTest {
    MyStack myStack;
    Deque<Integer> controlStack;

    @Before
    public void setUp() throws Exception {
        myStack = new MyStack();
        controlStack = new ArrayDeque<>();
        assertTrue(myStack.empty());
        assertTrue(controlStack.isEmpty());
    }

    @Test
    public void shouldBeSameAsStackForEmptyCheckAndAddAndPeek() throws Exception {
        myStack.push(1);
        controlStack.push(1);

        assertEquals(1, myStack.top());
        assertEquals(1, (int) controlStack.peek());
    }

    @Test
    public void shouldBeSameAsStackForMultipleAddAndPeekAndPoll() throws Exception {
        myStack.push(1);
        controlStack.push(1);

        myStack.push(2);
        controlStack.push(2);

        assertEquals(2, myStack.top());
        assertEquals(2, (int) controlStack.peek());

        myStack.pop();
        controlStack.pop();

        assertEquals(1, myStack.top());
        assertEquals(1, (int) controlStack.peek());

        myStack.push(3);
        controlStack.push(3);

        assertEquals(3, myStack.top());
        assertEquals(3, (int) controlStack.peek());

        myStack.pop();
        controlStack.pop();

        assertEquals(1, myStack.top());
        assertEquals(1, (int) controlStack.peek());

        myStack.push(5);
        controlStack.push(5);

        myStack.push(6);
        controlStack.push(6);

        assertEquals(6, myStack.top());
        assertEquals(6, (int) controlStack.peek());

        myStack.pop();
        controlStack.pop();

        assertEquals(5, myStack.top());
        assertEquals(5, (int) controlStack.peek());

        myStack.pop();
        controlStack.pop();

        assertEquals(1, myStack.top());
        assertEquals(1, (int) controlStack.peek());

        myStack.pop();
        controlStack.pop();

        assertTrue(myStack.empty());
        assertTrue(controlStack.isEmpty());
    }
}