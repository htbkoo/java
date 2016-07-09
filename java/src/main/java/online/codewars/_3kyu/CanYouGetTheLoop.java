package online.codewars._3kyu;

import online.codewars.util.Node;

/**
 * Created by Hey on 9 Jul 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

/*

You are given a node that is the beginning of a linked list. This list always contains a tail and a loop.

Your objective is to determine the length of the loop.

For example in the following picture the tail's size is 3 and the loop size is 11.
Image and video hosting by TinyPic

// Use the `getNext()` method to get the following node.

node.getNext()

    Thanks to shadchnev, I broke all of the methods from the Hash class.

    Don't miss dmitry's article in the discussion after you pass the Kata !!

* */

@SuppressWarnings("WeakerAccess")
public class CanYouGetTheLoop {
    public static class LoopInspector {

        public int loopSize(Node node) {
            Node fastPointer = node.getNext().getNext();
            Node slowPointer = node.getNext();

            while (fastPointer != slowPointer) {
                fastPointer = fastPointer.getNext().getNext();
                slowPointer = slowPointer.getNext();
            }

            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
            int count = 1;

            while (fastPointer != slowPointer) {
                ++count;
                fastPointer = fastPointer.getNext().getNext();
                slowPointer = slowPointer.getNext();
            }

            return count;
        }

    }
}
