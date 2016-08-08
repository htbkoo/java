package algo.practice.ds.tree;

import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Hey on 3 Aug 2016
 */
public abstract class SimpleBinarySearchTreeTest<T extends Comparable<? super T>> extends TreeTest<T> {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    protected Tree<T> getTree() {
        return new SimpleBinarySearchTree<>();
    }

    @Override
    @Test
    public void shouldDelete() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(StringContains.containsString("not found in the tree!"));
        binaryTree.delete(getDeleteParam());
    }
}