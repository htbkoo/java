package online.leetcode;

import com.google.common.collect.ImmutableList;
import online.leetcode.DesignTwitter.Twitter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Hey on 22 Jun 2016
 */
@RunWith(Parameterized.class)
public class DesignTwitterTest {
    private static final Logger LOGGER = LogManager.getLogger(DesignTwitterTest.class);

    private Action[] fActions;
    private int[][] fParameters;
    //    private int[][] fExpected;
    private List<Integer>[] fExpected;


    public DesignTwitterTest(@SuppressWarnings("UnusedParameters") String name, String[] fActions, int[][] fParameters, int[][] fExpected) {
        this.fActions = convertArray(fActions, Action::of, Action.class);
        this.fParameters = fParameters;

        Collector<Integer, List<Integer>, List<Integer>> collector = Collector.of(
                ArrayList<Integer>::new,
                List::add,
                (l, r) -> {
                    if (l == null || r == null) {
                        return null;
                    } else {
                        l.addAll(r);
                        return l;
                    }
                }
        );
//        Cast to Object is necessary, otherwise Compilation error is thrown
        //noinspection unchecked,RedundantCast
        this.fExpected = this.convertArray(fExpected
//                , i -> Stream.of(i).<List<Integer>>map(is -> is == null ? null : Arrays.stream(is).boxed().collect(Collectors.toList())).collect(Collectors.toList())
                , i -> {
                    if (i!=null){
                        return Arrays.stream(i).boxed().collect(Collectors.toList());
                    }else{
                        return null;
                    }
                }
                , (Class<? extends List<Integer>>)(Object)List.class);
    }

    private <F, T> T[] convertArray(F[] fActions, Function<F, T> convertFunction, Class<? extends T> toClass) {
        //noinspection unchecked
        return Arrays.stream(fActions).map(convertFunction).toArray(size -> (T[]) Array.newInstance(toClass, size));
    }

    @SuppressWarnings("unused")
    private Action[] convertStringsToActions(String[] fActions) {
        return Arrays.stream(fActions).map(Action::of).toArray(Action[]::new);
    }

    @Parameterized.Parameters(name = "{index}: DesignTwitter({0})")
    public static Collection<Object[]> getData() throws Exception {
        return asList(
                new Object[]{
                        "Default Test Case",
                        new String[]{"Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"},
                        new int[][]{new int[]{}, new int[]{1, 5}, new int[]{1}, new int[]{1, 2}, new int[]{2, 6}, new int[]{1}, new int[]{1, 2}, new int[]{1}},
                        new int[][]{null, null, new int[]{5}, null, null, new int[]{6, 5}, null, new int[]{5}},
                },
                new Object[]{
                        "Empty Test Case",
                        new String[]{"Twitter"},
                        new int[][]{new int[]{}},
                        new int[][]{null},
                },
                new Object[]{
                        "Failed Large Test Case",
                        new String[]{"Twitter"},
                        new int[][]{new int[]{}},
                        new int[][]{null},
                }
        );
    }

    @Test
    public void shouldRunTwitter() throws Exception {
        Twitter twitter = null;
        checkAndWarnIfNotInitialized();
        for (int i = 0; i < fActions.length; ++i) {
            final Action action = fActions[i];
            final List<Integer> expected = fExpected[i];
            final int[] parameter = fParameters[i];

            if (action.equals(Action.TWITTER)) {
                warnIfAlreadyInitialized(twitter);
                twitter = new Twitter();
            } else {
                if (expected != null) {
                    assertThat(expected, is(action.operate(twitter, parameter)));
                } else {
                    action.operate(twitter, parameter);
                }
            }
        }
    }

    private void warnIfAlreadyInitialized(Twitter twitter) {
        if (twitter != null) {
            LOGGER.warn("This is NOT the first initialization command received! Twitter object would be re-initialized and all users and tweets record are lost!");
        }
    }

    private void checkAndWarnIfNotInitialized() {
        if (fActions.length > 0) {
            if (!fActions[0].equals(Action.TWITTER)) {
                LOGGER.warn("The first action is not initialization! Most likely the test would fail due to NullPointerException!");
            }
        }
    }

    private enum Action {
        TWITTER("Twitter", (__, ___) -> {
            throw new IllegalStateException("Should not call TWITTER.operate().");
        }),
        POST_TWEET("postTweet", (t, params) -> {
            assertParamsLength(params, 2);
            t.postTweet(params[0], params[1]);
            return null;
        }),
        FOLLOW("follow", (t, params) -> {
            assertParamsLength(params, 2);
            t.follow(params[0], params[1]);
            return null;
        }),
        UNFOLLOW("unfollow", (t, params) -> {
            assertParamsLength(params, 2);
            t.unfollow(params[0], params[1]);
            return null;
        }),
        GET_NEWS_FEED("getNewsFeed", (t, params) -> {
            assertParamsLength(params, 1);
            return t.getNewsFeed(params[0]);
        });

        private static void assertParamsLength(int[] params, int expectedParamsLength) {
            if (params.length != expectedParamsLength) {
                throw new IllegalArgumentException(String.format("Size of Params is not correct! Expected: %d, Actual %d", expectedParamsLength, params.length));
            }
        }

        private final String inputName;
        private final BiFunction<Twitter, int[], List<Integer>> operation;

        Action(String inputName, BiFunction<Twitter, int[], List<Integer>> operation) {
            this.inputName = inputName;
            this.operation = operation;
        }

        public static Action of(String str) {
            switch (str) {
                case "Twitter":
                    return TWITTER;
                case "postTweet":
                    return POST_TWEET;
                case "follow":
                    return FOLLOW;
                case "unfollow":
                    return UNFOLLOW;
                case "getNewsFeed":
                    return GET_NEWS_FEED;
                default:
                    throw new IllegalArgumentException(String.format("\"%s\" is not a known action! Possible values are: %s", str, getAllActionAsStrings()));
            }
        }

        private static String getAllActionAsStrings() {
            return Arrays.toString(Action.values());
        }

        @Override
        public String toString() {
            return inputName;
        }

        public List<Integer> operate(Twitter twitter, int[] fParameter) {
            return operation.apply(twitter, fParameter);
        }
    }

    @Ignore
    @Test
    public void shouldHandleTweetsInExample() throws Exception {
        Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        assertThat("User 1's news feed should return a list with 1 tweet id -> [5].", twitter.getNewsFeed(1), is(ImmutableList.of(5)));

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        assertThat("User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.", twitter.getNewsFeed(1), is(ImmutableList.of(6, 5)));

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        assertThat("User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.", twitter.getNewsFeed(1), is(ImmutableList.of(5)));

    }

    /*Failing casse:

    ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","unfollow","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","getNewsFeed","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","getNewsFeed","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","unfollow","getNewsFeed","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","getNewsFeed","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet"]
[[],[11,994],[4,303],[1,113],[18,309],[8,905],[6,605],[1,210],[15,15],[1,88],[1,704],[8],[9,59],[4,851],[13,974],[2,133],[15,255],[15,662],[16,21],[13,227],[17],[5,603],[10,7],[5,816],[7,792],[12,260],[5],[4,586],[1,645],[20],[15,171],[16,18],[3,812],[15,153],[12,726],[6,508],[17,817],[5,6],[3,667],[5,599],[13,353],[11,282],[7,226],[18,423],[13,875],[2,738],[6,727],[7,374],[19,811],[8,418],[2,179],[3,476],[9,15],[16,8],[19,827],[17,203],[13,246],[14,8],[13,750],[4,595],[1,793],[17,995],[11,589],[2,115],[18,870],[15,426],[18,953],[10,318],[10,419],[2,164],[9],[18,854],[3,394],[17],[4,834],[4,349],[2,16],[13,534],[3,773],[4,292],[5,951],[17,554],[4,646],[6,412],[15,548],[8,188],[5,539],[18,732],[8,591],[11,733],[1,517],[8,156],[13,331],[11,889],[12,782],[11],[2,578],[16,487],[12,640],[14,112],[10,901],[8,807],[7,818],[7,627],[14,9],[4,522],[7,505],[9,13],[3],[1,971],[18,808],[1,17],[7,197],[7,361],[2,986],[17,6],[7,211],[15,342],[5,538],[1,711],[11,863],[17,339],[5,656],[4,402],[1,514],[11,566],[12,11],[12],[19,899],[19,526],[20,799],[4,1],[17,363],[7,845],[15,329],[17,369],[18,18],[15,848],[5,928],[18,105],[18],[17,785],[11,457]]

    * */
}