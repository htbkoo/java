package algo.practice.ds.tree;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Hey on 3 Aug 2016
 */
public class ObjectOrientedCompleteBinaryTreeIntegerTest extends ObjectOrientedCompleteBinaryTreeTest<Integer> {
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

    @Test
    @Override
    public void shouldDelete() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        binaryTree.delete(getDeleteParam());
    }


    @Test
    public void shouldCheckIsExistAndSimpleCase() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        assertThat(binaryTree.isExist(getInsertParam()), is(false));

        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
        binaryTree.insert(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(true));
        binaryTree.delete(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
    }
}
