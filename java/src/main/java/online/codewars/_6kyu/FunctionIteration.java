package online.codewars._6kyu;

import java.util.function.Function;

/**
 * Created by Hey on 20 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/function-iteration/train/java
 */

/*

The purpose of this kata is to write a higher-order function which is capable of creating a function that iterates on a specified function a given number of times. This new functions takes in an argument as a seed to start the computation from.

For instance, consider the function getDouble. When run twice on value 3, yields 12 as shown below.

getDouble(3) => 6
getDouble(6) => 12

Let us name the new function createIterator and we should be able to obtain the same result using createIterator as shown below:

var doubleIterator = createIterator(getDouble, 2); // This means, it runs *getDouble* twice
doubleIterator(3) => 12

For the sake of simplicity, all function inputs to createIterator would be functions returning a small number and number of iterations would always be integers.

* */

public class FunctionIteration {
    public static class GetIterator {
        public static Function<Integer, Integer> getIterator(Function<Integer, Integer> func, int times) {
            if (times <= 1) {
                return func;
            }
            return func.andThen(getIterator(func, times - 1));
        }
    }
}
