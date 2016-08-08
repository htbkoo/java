package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public class SimpleBinarySearchTreeStringTest extends SimpleBinarySearchTreeTest<String> {
    @Override
    protected String getInsertParam() {
        return "C";
    }

    @Override
    protected String getDeleteParam() {
        return "B";
    }

    @Override
    protected String getIsExistParam() {
        return "A";
    }
}
