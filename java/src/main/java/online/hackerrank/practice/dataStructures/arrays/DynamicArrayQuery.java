package online.hackerrank.practice.dataStructures.arrays;

import java.util.List;

public abstract class DynamicArrayQuery implements StateUpdater {
    private final int x;
    private final int y;

    DynamicArrayQuery(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static DynamicArrayQuery fromInts(List<Integer> ints) {
        int type = ints.get(0);
        int x = ints.get(1);
        int y = ints.get(2);
        switch (type) {
            case 1:
                return new AppendQuery(x, y);
            case 2:
                return new FetchValueQuery(x, y);
            default:
                throw new IllegalArgumentException(String.format("Unknown Query Type %d", type));
        }
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }
}
