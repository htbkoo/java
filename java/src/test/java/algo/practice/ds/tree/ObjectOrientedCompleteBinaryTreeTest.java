package algo.practice.ds.tree;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Hey on 3 Aug 2016
 */
public abstract class ObjectOrientedCompleteBinaryTreeTest<T> extends TreeTest<T> {
    @Rule
    public ExpectedException exception = ExpectedException.none();


    protected Tree<T> getTree() {
        return new ObjectOrientedCompleteBinaryTree<>();
    }

    @Test
    @Override
    public void shouldDelete() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        binaryTree.delete(getDeleteParam());
    }

    @Test
    @Override
    public void shouldCheckIsExist() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        assertThat(binaryTree.isExist(getInsertParam()), is(false));

        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
        binaryTree.insert(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(true));
        binaryTree.delete(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
    }

    @Test
    @Override
    public void shouldCheckSimpleCase() throws Exception {
        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
        assertThat(binaryTree.isExist(getInsertParam()), is(false));
        assertThat(binaryTree.isExist(getDeleteParam()), is(false));


        binaryTree.insert(getIsExistParam());
        binaryTree.insert(getInsertParam());
        binaryTree.insert(getDeleteParam());

        assertThat(binaryTree.isExist(getIsExistParam()), is(true));
        assertThat(binaryTree.isExist(getInsertParam()), is(true));
        assertThat(binaryTree.isExist(getDeleteParam()), is(true));
    }
}