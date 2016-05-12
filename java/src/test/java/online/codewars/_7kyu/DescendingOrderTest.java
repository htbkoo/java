package online.codewars._7kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 12 May 2016
 */
public class DescendingOrderTest {

    @Test
    public void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }

    @Test
    public void exampleTestOnWebSite() throws Exception {
        assertEquals(654321, DescendingOrder.sortDesc(145263));
    }

    @Test
    public void shouldSortDesc() throws Exception {
        assertEquals(543322111, DescendingOrder.sortDesc(231231451));
    }
}