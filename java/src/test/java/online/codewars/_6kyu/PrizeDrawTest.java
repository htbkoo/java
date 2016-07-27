package online.codewars._6kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._6kyu.PrizeDraw.Rank;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 25 Jul 2016
 */
@RunWith(Parameterized.class)
public class PrizeDrawTest {

    @Parameterized.Parameters(name = "[{0}] Rank.nthRank()={4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"Fixed Tests 1", "", new Integer[]{4, 2, 1, 4, 3, 1, 2}, 4, "No participants"},
                new Object[]{"Fixed Tests 2", "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin", new Integer[]{4, 2, 1, 4, 3, 1, 2}, 8, "Not enough participants"},
                new Object[]{"Fixed Tests 3", "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin", new Integer[]{4, 2, 1, 4, 3, 1, 2}, 4, "Benjamin"},
                new Object[]{"Fixed Tests 4", "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden", new Integer[]{1, 3, 5, 5, 3, 6}, 2, "Matthew"},
                new Object[]{"Submit Cases 5", "Aubrey,Olivai,Abigail,Chloe,Andrew,Elizabeth", new Integer[]{3, 1, 4, 4, 3, 2}, 4, "Abigail"},
                new Object[]{"Submit Cases 6", "Lagon,Lily", new Integer[]{1, 5}, 2, "Lagon"},
                new Object[]{"Submit Cases 7", "Elijah,Michael,Avery,Sophia,Samantha", new Integer[]{2, 1, 5, 2, 2}, 3, "Sophia"},
                new Object[]{"Submit Cases 8", "William,Willaim,Olivia,Olivai,Lily,Lyli", new Integer[]{1, 1, 1, 1, 1, 1}, 1, "Willaim"},
                new Object[]{"Submit Cases 9", "Addison,William,Jayden", new Integer[]{3, 5, 6}, 1, "William"},
                new Object[]{"Submit Cases 10", "Joshua,Grace,Isabella", new Integer[]{1, 5, 4}, 1, "Isabella"},
                new Object[]{"Submit Cases 11", "Elijah,Addison", new Integer[]{3, 6}, 2, "Elijah"},
                new Object[]{"Submit Cases 12", "Willaim,Liam,Daniel,Alexander", new Integer[]{6, 4, 6, 2}, 2, "Daniel"},
                new Object[]{"Submit Cases 13", "Avery,Olivai,Sophia,Michael,Elizabeth,Willaim,Liam", new Integer[]{5, 5, 3, 2, 1, 3, 6}, 5, "Sophia"},
                new Object[]{"Submit Cases 14", "Liam,Madison,Lyli,Jacob,Matthew,Michael", new Integer[]{2, 6, 5, 5, 3, 4}, 6, "Liam"},
                new Object[]{"Submit Cases 15", "Sophia,Robert,Abigail,Grace,Lagon", new Integer[]{2, 6, 5, 5, 3, 4}, 5, "Sophia"}
        );
    }

    private final String st;
    private final Integer[] we;
    private final int n;
    private final String fExpected;

    public PrizeDrawTest(@SuppressWarnings("UnusedParameters") String name, String st, Integer[] we, int n, String fExpected) {
        this.st = st;
        this.we = we;
        this.n = n;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldGetNthRank() throws Exception {
        assertEquals(fExpected, Rank.nthRank(st, we, n));
    }

    @Ignore
    @Test
    public void test() {
        System.out.println("Fixed Tests");
        String st = "";
        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("No participants", Rank.nthRank(st, we, 4));
        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Not enough participants", Rank.nthRank(st, we, 8));
        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Benjamin", Rank.nthRank(st, we, 4));
        st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        we = new Integer[]{1, 3, 5, 5, 3, 6};
        assertEquals("Matthew", Rank.nthRank(st, we, 2));
    }
}