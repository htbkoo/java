package algo.practice.ds;

import algo.practice.utils.Node;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 13/9/15.
 */
public class PracticeSinglyLinkedListTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldCreateSinglyLinkedList() throws Exception {
        PracticeSinglyLinkedList<Integer> psll = new PracticeSinglyLinkedList<>(Node.createNodes(Lists.<Integer>newArrayList(1, 2, 4, 5, 3)));

        assertEquals((Integer) 1, psll.getHead());
        assertEquals("PracticeSinglyLinkedList{ Node{value: 1} -> Node{value: 2} -> Node{value: 4} -> Node{value: 5} -> Node{value: 3} -> end, all content = {1, 2, 4, 5, 3}}", psll.toString());
    }
}