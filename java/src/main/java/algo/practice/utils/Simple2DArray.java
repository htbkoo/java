package algo.practice.utils;

import com.sun.istack.internal.NotNull;

import java.util.Optional;

/**
 * Created by Hey on 21/9/15
 */
public class Simple2DArray<T> {
    private final Optional<T>[][] matrix;

    public Simple2DArray(Class<T> clazz, int m, int n) {
        //noinspection unchecked
        this.matrix = new Optional[m + 1][n + 1];
    }

    /*
    public void put(int i, int j, @NotNull T element) {
        if (matrix.get(i) == null) {
            matrix.add(i, Lists.newArrayList());
        }

        if (element == null) {
            throw new IllegalArgumentException("Element is null!");
        } else {
            Optional<T> optional = Optional.of(element);
            matrix.get(i).add(j, optional);
        }
    }
    */

    public void put(int i, int j, @NotNull T element) {
        this.matrix[i][j] = Optional.of(element);
    }

    /*
    public Optional<T> get(int i, int j) {
        List<Optional<T>> row = matrix.get(i);
        if (row == null) {
            matrix.add(i, Lists.newArrayList());
            return Optional.empty();
        }
        if (row.get(j) == null)
            row.add(j, Optional.empty());
        return row.get(j);
    }
    */

    public Optional<T> get(int i, int j) {
        if (this.matrix[i][j] == null) {
            this.matrix[i][j] = Optional.empty();
        }
        return this.matrix[i][j];
    }
}
