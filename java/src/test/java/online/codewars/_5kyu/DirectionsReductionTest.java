package online.codewars._5kyu;

import org.junit.Test;

import static online.codewars._5kyu.DirectionsReduction.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 21 May 2016
 */
public class DirectionsReductionTest {
    @Test
    public void testSimpleDirReduc() throws Exception {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

        assertArrayEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }
}