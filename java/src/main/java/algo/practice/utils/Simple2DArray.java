package algo.practice.utils;

import java.util.Optional;

/**
 * Created by Hey on 21/9/15
 */
public class Simple2DArray<T> {
    private final Optional<? extends T>[][] matrix;
    private final int firstDimensionSize;
    private final int secondDimensionSize;

    public Simple2DArray(int m, int n) {
        //noinspection unchecked
        this.matrix = new Optional[m + 1][n + 1];
        this.firstDimensionSize = m;
        this.secondDimensionSize = n;
    }

    public void put(int i, int j, T element) {
        this.matrix[i][j] = Optional.of(element);
    }

    public Optional<? extends T> get(int i, int j) {
        if (this.matrix[i][j] == null) {
            this.matrix[i][j] = Optional.empty();
        }
        return this.matrix[i][j];
    }

    public Optional<? extends T>[][] getMatrix() {
        return matrix;
    }

    public int getFirstDimensionSize() {
        return firstDimensionSize;
    }

    public int getSecondDimensionSize() {
        return secondDimensionSize;
    }
}
