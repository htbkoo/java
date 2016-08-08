package algo.practice.ds.tree;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Hey on 3 Aug 2016
 */
public abstract class TreeTest<T> {
    protected Tree<T> binaryTree = getTree();

    protected abstract Tree<T> getTree();

    @Test
    public void shouldInsert() throws Exception {
        binaryTree.insert(getInsertParam());
    }

    protected abstract T getInsertParam();

    @Test
    public void shouldDelete() throws Exception {
        binaryTree.delete(getDeleteParam());
    }

    protected abstract T getDeleteParam();

    @Test
    public void shouldCheckIsExist() throws Exception {
        assertThat(binaryTree.isExist(getInsertParam()), is(false));

        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
        binaryTree.insert(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(true));
        binaryTree.delete(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
    }

    @Test
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

        binaryTree.delete(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
        assertThat(binaryTree.isExist(getInsertParam()), is(true));
        assertThat(binaryTree.isExist(getDeleteParam()), is(true));

        binaryTree.delete(getDeleteParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(false));
        assertThat(binaryTree.isExist(getInsertParam()), is(true));
        assertThat(binaryTree.isExist(getDeleteParam()), is(false));

        binaryTree.insert(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(true));
        assertThat(binaryTree.isExist(getInsertParam()), is(true));
        assertThat(binaryTree.isExist(getDeleteParam()), is(false));

        binaryTree.delete(getInsertParam());
        binaryTree.insert(getIsExistParam());
        assertThat(binaryTree.isExist(getIsExistParam()), is(true));
        assertThat(binaryTree.isExist(getInsertParam()), is(false));
        assertThat(binaryTree.isExist(getDeleteParam()), is(false));
    }

    protected abstract T getIsExistParam();

    @Ignore
    @Test
    public void shouldTestStraightThrough() throws Exception {
    }

}