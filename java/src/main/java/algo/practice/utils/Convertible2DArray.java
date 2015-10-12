package algo.practice.utils;

import java.lang.reflect.Array;
import java.util.Optional;

/**
 * Created by Hey on 10/10/15
 * <p>
 * -------------------------------
 * <p>
 * Extending the Simple2DArray, this Convertible2DArray provide the functionality for the user to get the plain2DArray
 * at the cost of supply the Class type during construction.
 * <p>
 * This class is necessary due to type erasure - during runtime, the internal type of the Optional (the matrix) is erased.
 * The class type MUST be supplied as a parameter
 */
public class Convertible2DArray<T> extends Simple2DArray<T> {

    private final Class<T> clazz;

    public Convertible2DArray(Class<T> clazz, int m, int n) {
        super(m, n);
        this.clazz = clazz;
    }

    public T[][] getPlainArray() {
//        Illegal in Java
//        T[][] plainArray = new T[matrix.length][];

//        So have to initialize in this way
        final int numOfRows = getMatrix().length;
        //noinspection unchecked
        T[][] plainArray = (T[][]) Array.newInstance(clazz, getSecondDimensionSize());

        for (int row = 0; row < numOfRows; row++) {
            final int numOfCols = getMatrix()[row].length;
            for (int col = 0; col < numOfCols; col++) {
                plainArray[row][col] = getNullableValueFromMatrix(row, col);
            }
        }
//        (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        System.arraycopy();
//        if(array.length < testSize)
//            array = (T[]) Array.newInstance(array.getClass().getComponentType(), testSize); //Type safety: Unchecked cast from Object to T[]
//        System.out.println("in this case: "+array.getClass().getComponentType().getSimpleName());
        return plainArray;
    }

    private T getNullableValueFromMatrix(int row, int col) {
        if (getMatrix()[row][col].isPresent()) {
            return getMatrix()[row][col].get();
        } else {
            return null;
        }
    }

    public Optional<? extends T>[][] getOptionalArray() {
        return getMatrix();
    }
}
