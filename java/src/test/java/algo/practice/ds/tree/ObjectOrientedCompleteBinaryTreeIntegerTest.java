package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public class ObjectOrientedCompleteBinaryTreeIntegerTest extends ObjectOrientedCompleteBinaryTreeTest<Integer> {
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
}
