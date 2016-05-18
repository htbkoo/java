package online.codewars._5kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 17 May 2016
 */
public class DoubleColaTest {
    @Test
    public void test1() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 1;
        assertEquals("Sheldon", DoubleCola.Line.WhoIsNext(names, n));
    }

    @Test
    public void test2() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 6;
        assertEquals("Sheldon", DoubleCola.Line.WhoIsNext(names, n));
    }

    @Test
    public void shouldReturn5thPerson() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 5;
        assertEquals("Howard", DoubleCola.Line.WhoIsNext(names, n));
    }

    @Test
    public void shouldReturn7thPerson() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 7;
        assertEquals("Sheldon", DoubleCola.Line.WhoIsNext(names, n));
    }

    @Test
    public void shouldReturn8thPerson() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 8;
        assertEquals("Leonard", DoubleCola.Line.WhoIsNext(names, n));
    }

    @Test
    public void shouldReturn15thPerson() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 15;
        assertEquals("Howard", DoubleCola.Line.WhoIsNext(names, n));
    }

    @Test
    public void shouldReturn16thPerson() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 16;
        assertEquals("Sheldon", DoubleCola.Line.WhoIsNext(names, n));
    }
}