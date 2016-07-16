package online.codewars._5kyu;

import org.junit.Test;

import static online.codewars._5kyu.WeightForWeight.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 16 Jul 2016
 */
public class WeightForWeightTest {
    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}