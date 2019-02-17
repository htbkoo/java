package online.hackerrank.practice.dataStructures.arrays;

public class AppendQuery extends DynamicArrayQuery {
    AppendQuery(int x, int y) {
        super(x, y);
    }

    @Override
    public DynamicArrayState update(DynamicArrayState prevState) {
        final int index = getIndex(prevState.getLastAnswer(), prevState.getN());
        return prevState.withAppendToSeqList(getY(), index);
    }
}