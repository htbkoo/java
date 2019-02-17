package online.hackerrank.practice.dataStructures.arrays;

import java.util.List;

public class FetchValueQuery extends DynamicArrayQuery {
    FetchValueQuery(int x, int y) {
        super(x, y);
    }

    @Override
    public DynamicArrayState update(DynamicArrayState prevState) {
        final int index = getIndex(prevState.getLastAnswer(), prevState.getN());
        final List<Integer> seqList = prevState.getSeqLists().get(index);
        final int size = seqList.size();
        final Integer answer = seqList.get(getY() % size);
        return prevState.withAnswer(answer);
    }
}