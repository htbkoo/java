package online.codewars._6kyu;

import online.codewars._6kyu.HelpTheBookseller.StockList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 13 Aug 2016
 */
public class HelpTheBooksellerTest {
    @Test
    public void test1() {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B"};
        assertEquals("(A : 200) - (B : 1140)",
                StockList.stockSummary(art, cd));
    }
}