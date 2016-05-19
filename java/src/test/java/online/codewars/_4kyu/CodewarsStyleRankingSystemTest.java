package online.codewars._4kyu;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static online.codewars._4kyu.CodewarsStyleRankingSystem.User;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Hey on 18 May 2016
 */
public class CodewarsStyleRankingSystemTest {
    @Test
    public void should_Create_Test_User_And_Test_Example() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-7);
        assertUserProgress(user, 10);
        user.incProgress(-5); // will add 90 progress
        assertUserProgress(user, 0);
        assertUserRank(user, -7);
    }

    @Test
    public void should_At_Rank_1_Obtain_1_Progress_For_Completing_Activity_Rank_Minus_1() throws Exception {
        final User user = createUserAndAssertInitialState();
//        To maintain a good encapsulation behaviour by not accessing the public field directly
        ReflectionTestUtils.setField(user, "rank", 1);
        assertUserProgress(user, 0);
        assertUserRank(user, 1);
        user.incProgress(-1);
        assertUserProgress(user, 1);
        assertUserRank(user, 1);
    }

    @Test
    public void should_At_Rank_Minus_1_Obtain_10_Progress_For_Completing_Activity_Rank_1() throws Exception {
        final User user = createUserAndAssertInitialState();
//        To maintain a good encapsulation behaviour by not accessing the public field directly
        ReflectionTestUtils.setField(user, "rank", -1);
        assertUserProgress(user, 0);
        assertUserRank(user, -1);
        user.incProgress(1);
        assertUserProgress(user, 10);
        assertUserRank(user, -1);
    }

    @Test
    public void should_Obtain_No_More_Progress_After_Upgrading_To_Rank_8() throws Exception {
        final User user = createUserAndAssertInitialState();
//        To maintain a good encapsulation behaviour by not accessing the public field directly
        ReflectionTestUtils.setField(user, "rank", 7);
        assertUserProgress(user, 0);
        assertUserRank(user, 7);
        for (int i = 0; i < 10; ++i) {
            assertUserProgress(user, (10 * i));
            assertUserRank(user, 7);
            user.incProgress(8);
        }

        assertUserIntProperty(user.rank, "rank is still ", 8);
        assertUserIntProperty(user.progress, "after reaching rank 8, progress should stop at ", 0);
        user.incProgress(8);
        assertUserIntProperty(user.rank, "rank is still ", 8);
        assertUserIntProperty(user.progress, "after reaching rank 8, progress should stop at ", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_Throw_Exception_For_Activity_Rank_0() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_Throw_Exception_For_Activity_Rank_Minus_9() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_Throw_Exception_For_Activity_Rank_9() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(9);
    }

    @Test
    public void should_Obtain_3_Progress_For_Completing_Activity_Of_Same_Rank_Before_Rank_8() throws Exception {
        for (int rank = -8; rank <= 7; ++rank) {
            if (rank == 0) { // skip invalid rank which is not the purpose of this test
                continue;
            }
            final User user = createUserAndAssertInitialState();
//        To maintain a good encapsulation behaviour by not accessing the public field directly
            ReflectionTestUtils.setField(user, "rank", rank);

            assertUserProgress(user, 0);
            assertUserRank(user, rank);
            user.incProgress(rank);
            assertUserProgress(user, 3);
            assertUserRank(user, rank);
        }
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_10_Progress_For_Completing_Activity_Rank_Minus_7() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-7);
        assertUserProgress(user, 10);
        assertUserRank(user, -8);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_40_Progress_For_Completing_Activity_Rank_Minus_3() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-6);
        assertUserProgress(user, 40);
        assertUserRank(user, -8);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_90_Progress_For_Completing_Activity_Rank_Minus_5() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-5);
        assertUserProgress(user, 90);
        assertUserRank(user, -8);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_160_Progress_For_Completing_Activity_Rank_Minus_4() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-4);
        assertUserProgress(user, 60);
        assertUserRank(user, -7);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_250_Progress_For_Completing_Activity_Rank_Minus_3() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-3);
        assertUserProgress(user, 50);
        assertUserRank(user, -6);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_360_Progress_For_Completing_Activity_Rank_Minus_2() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-2);
        assertUserProgress(user, 60);
        assertUserRank(user, -5);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_490_Progress_For_Completing_Activity_Rank_Minus_1() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(-1);
        assertUserProgress(user, 90);
        assertUserRank(user, -4);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_640_Progress_For_Completing_Activity_Rank_1() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(1);
        assertUserProgress(user, 40);
        assertUserRank(user, -2);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_810_Progress_For_Completing_Activity_Rank_2() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(2);
        assertUserProgress(user, 10);
        assertUserRank(user, 1);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_1000_Progress_For_Completing_Activity_Rank_3() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(3);
        assertUserProgress(user, 0);
        assertUserRank(user, 3);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_1210_Progress_For_Completing_Activity_Rank_4() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(4);
        assertUserProgress(user, 10);
        assertUserRank(user, 5);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_1440_Progress_For_Completing_Activity_Rank_5() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(5);
        assertUserProgress(user, 40);
        assertUserRank(user, 7);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_1690_Progress_And_Capped_For_Completing_Activity_Rank_6() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(6);
        assertUserProgress(user, 0);
        assertUserRank(user, 8);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_1960_Progress_And_Capped_For_Completing_Activity_Rank_7() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(7);
        assertUserProgress(user, 0);
        assertUserRank(user, 8);
    }

    @Test
    public void should_At_Rank_Minus_8_Obtain_2250_Progress_And_Capped__For_Completing_Activity_Rank_8() throws Exception {
        final User user = createUserAndAssertInitialState();
        user.incProgress(8);
        assertUserProgress(user, 0);
        assertUserRank(user, 8);
    }

    @Test
    public void should_At_Have_0_Progress_After_Reaching_Rank_8() throws Exception {
        final User user = createUserAndAssertInitialState();
        ReflectionTestUtils.setField(user, "rank", 7);
        user.incProgress(6);
        assertUserProgress(user, 1);
        assertUserRank(user, 7);

        for (int i = 0; i < 10; ++i) {
            assertUserProgress(user, (10 * i + 1));
            assertUserRank(user, 7);
            user.incProgress(8);
        }

        assertUserIntProperty(user.rank, "rank is still ", 8);
        assertUserIntProperty(user.progress, "after reaching rank 8, progress should stop at ", 0);
        user.incProgress(8);
        assertUserIntProperty(user.rank, "rank is still ", 8);
        assertUserIntProperty(user.progress, "after reaching rank 8, progress should stop at ", 0);
    }

    private User createUserAndAssertInitialState() {
        final User user = new User();
        assertUserIntProperty(user.rank, "A user starts at rank ", -8);
        assertUserIntProperty(user.progress, "progress starts at ", 0);
        return user;
    }


    private void assertUserRank(User user, int expectedRank) {
        assertUserIntProperty(user.rank, "rank is now ", expectedRank);
    }

    private void assertUserProgress(User user, int expectedProgress) {
        assertUserIntProperty(user.progress, "progress is now ", expectedProgress);
    }

    private void assertUserIntProperty(int actual, String message, int expected) {
        assertThat(message + expected, actual, is(expected));
    }
}