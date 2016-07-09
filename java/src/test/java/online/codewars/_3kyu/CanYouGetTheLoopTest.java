package online.codewars._3kyu;

import online.codewars.util.Node;
import org.junit.Test;

import static online.codewars._3kyu.CanYouGetTheLoop.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 9 Jul 2016
 */
public class CanYouGetTheLoopTest {

    private static class ConcreteNode implements Node {

        private ConcreteNode next;

        static Node createChain(int from, int loopSize) {
            ConcreteNode head = new ConcreteNode();
            ConcreteNode cur = head;
            for (int i = 1; i <= from; ++i) {
                cur.next = new ConcreteNode();
                cur = cur.next;
            }
            ConcreteNode startOfLoop = cur;
            for (int i = 1; i < loopSize; ++i) {
                cur.next = new ConcreteNode();
                cur = cur.next;
            }
            cur.next = startOfLoop;
            return head;
        }

        @Override
        public Node getNext() {
            return next;
        }
    }

    @Test
    public void loop_size_of_3() {
        Node list = ConcreteNode.createChain(1, 3);
        int result = new LoopInspector().loopSize(list);
        assertEquals("Incorrect loop size", 3, result);
    }

    @Test
    public void loop_size_of_29() {
        Node list = ConcreteNode.createChain(21, 29);
        int result = new LoopInspector().loopSize(list);
        assertEquals("Incorrect loop size", 29, result);
    }

    @Test
    public void loop_size_of_1087() {
        Node list = ConcreteNode.createChain(3904, 1087);
        int result = new LoopInspector().loopSize(list);
        assertEquals("Incorrect loop size", 1087, result);
    }

}