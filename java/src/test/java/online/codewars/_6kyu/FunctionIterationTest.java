package online.codewars._6kyu;

import org.junit.Test;

import java.util.function.Function;

import static online.codewars._6kyu.FunctionIteration.GetIterator.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 20 May 2016
 */
public class FunctionIterationTest {
    @Test
    public void testDoubling() throws Exception {
        Function<Integer, Integer> getDouble = x -> x * 2;
        Function<Integer, Integer> custDouble = getIterator(getDouble, 1);
        assertEquals("getDouble", 4, (int) custDouble.apply(2));
        Function<Integer, Integer> getQuadruple = getIterator(getDouble, 2);
        assertEquals("getQuadruple", 8, (int) getQuadruple.apply(2));
    }

    @Test
    public void testIncrementing() throws Exception {

        Function<Integer, Integer> getIncrement = x -> x +1 ;
        Function<Integer, Integer> custIncrement = getIterator(getIncrement, 1);
        assertEquals("custIncrement", 3, (int) custIncrement.apply(2));
        Function<Integer, Integer> thriceIncreament = getIterator(getIncrement, 3);
        assertEquals("Increment Thrice", 6, (int) thriceIncreament.apply(3));
    }
}