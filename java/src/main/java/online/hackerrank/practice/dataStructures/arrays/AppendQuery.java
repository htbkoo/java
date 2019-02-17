package online.hackerrank.practice.dataStructures.arrays;

public class AppendQuery extends DynamicArrayQuery {
    AppendQuery(int x, int y) {
        super(x, y);
    }

    @Override
    public DynamicArrayState update(DynamicArrayState prevState) {
        final int N = prevState.getSeqLists().size();
        final int index = getX() ^ prevState.getLastAnswer() % N;
        return prevState.withAppendToSeqList(getY(), index);
    }
}