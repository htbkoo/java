package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public class SimpleBinarySearchTreeLongTest extends SimpleBinarySearchTreeTest<Long> {
    @Override
    protected Long getInsertParam() {
        return 3L;
    }

    @Override
    protected Long getDeleteParam() {
        return 2L;
    }

    @Override
    protected Long getIsExistParam() {
        return 1L;
    }
}
