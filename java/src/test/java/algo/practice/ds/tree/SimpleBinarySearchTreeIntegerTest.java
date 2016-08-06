package algo.practice.ds.tree;

import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Hey on 3 Aug 2016
 */
public class SimpleBinarySearchTreeIntegerTest extends SimpleBinarySearchTreeTest<Integer> {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Override
    protected Integer getInsertParam() {
        return 3;
    }

    @Override
    protected Integer getDeleteParam() {
        return 2;
    }

    @Override
    protected Integer getIsExistParam() {
        return 1;
    }

    @Override
    @Test
    public void shouldDelete() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(StringContains.containsString("Target 2 not found in the tree!"));
        binaryTree.delete(getDeleteParam());
    }
}
