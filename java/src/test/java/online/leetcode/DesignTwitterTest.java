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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
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
    private List<Integer>[] fExpected;


    public DesignTwitterTest(@SuppressWarnings("UnusedParameters") String name, String[] fActions, int[][] fParameters, int[][] fExpected) {
        this.fActions = convertArray(fActions, Action::of, Action.class);
        this.fParameters = fParameters;

        //        Cast to Object is necessary, otherwise Compilation error is thrown
        //noinspection unchecked,RedundantCast
        this.fExpected = this.convertArray(fExpected
                , i -> {
                    if (i != null) {
                        return Arrays.stream(i).boxed().collect(Collectors.toList());
                    } else {
                        return null;
                    }
                }
                , (Class<? extends List<Integer>>) (Object) List.class);
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
                        "(Wrong Answer) Failed Test Case",
                        new String[]{"Twitter", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed"},
                        new int[][]{new int[]{}, new int[]{1, 5}, new int[]{1, 3}, new int[]{1, 101}, new int[]{1, 13}, new int[]{1, 10}, new int[]{1, 2}, new int[]{1, 94}, new int[]{1, 505}, new int[]{1, 333}, new int[]{1, 22}, new int[]{1, 11}, new int[]{1}},
                        new int[][]{null, null, null, null, null, null, null, null, null, null, null, null, new int[]{11, 22, 333, 505, 94, 2, 10, 13, 101, 3}},
                },
                new Object[]{
                        "(NPE) Failed Large Test Case",
                        new String[]{"Twitter", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "postTweet", "unfollow", "postTweet", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "follow", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "follow", "postTweet", "postTweet", "postTweet", "postTweet", "follow", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet", "follow", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "unfollow", "postTweet", "postTweet", "unfollow", "getNewsFeed", "postTweet", "postTweet", "follow", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "unfollow", "getNewsFeed", "postTweet", "postTweet", "postTweet", "unfollow", "postTweet", "postTweet", "postTweet", "postTweet", "unfollow", "postTweet", "postTweet", "postTweet", "getNewsFeed", "postTweet", "postTweet"},
                        new int[][]{new int[]{}, new int[]{11, 994}, new int[]{4, 303}, new int[]{1, 113}, new int[]{18, 309}, new int[]{8, 905}, new int[]{6, 605}, new int[]{1, 210}, new int[]{15, 15}, new int[]{1, 88}, new int[]{1, 704}, new int[]{8}, new int[]{9, 59}, new int[]{4, 851}, new int[]{13, 974}, new int[]{2, 133}, new int[]{15, 255}, new int[]{15, 662}, new int[]{16, 21}, new int[]{13, 227}, new int[]{17}, new int[]{5, 603}, new int[]{10, 7}, new int[]{5, 816}, new int[]{7, 792}, new int[]{12, 260}, new int[]{5}, new int[]{4, 586}, new int[]{1, 645}, new int[]{20}, new int[]{15, 171}, new int[]{16, 18}, new int[]{3, 812}, new int[]{15, 153}, new int[]{12, 726}, new int[]{6, 508}, new int[]{17, 817}, new int[]{5, 6}, new int[]{3, 667}, new int[]{5, 599}, new int[]{13, 353}, new int[]{11, 282}, new int[]{7, 226}, new int[]{18, 423}, new int[]{13, 875}, new int[]{2, 738}, new int[]{6, 727}, new int[]{7, 374}, new int[]{19, 811}, new int[]{8, 418}, new int[]{2, 179}, new int[]{3, 476}, new int[]{9, 15}, new int[]{16, 8}, new int[]{19, 827}, new int[]{17, 203}, new int[]{13, 246}, new int[]{14, 8}, new int[]{13, 750}, new int[]{4, 595}, new int[]{1, 793}, new int[]{17, 995}, new int[]{11, 589}, new int[]{2, 115}, new int[]{18, 870}, new int[]{15, 426}, new int[]{18, 953}, new int[]{10, 318}, new int[]{10, 419}, new int[]{2, 164}, new int[]{9}, new int[]{18, 854}, new int[]{3, 394}, new int[]{17}, new int[]{4, 834}, new int[]{4, 349}, new int[]{2, 16}, new int[]{13, 534}, new int[]{3, 773}, new int[]{4, 292}, new int[]{5, 951}, new int[]{17, 554}, new int[]{4, 646}, new int[]{6, 412}, new int[]{15, 548}, new int[]{8, 188}, new int[]{5, 539}, new int[]{18, 732}, new int[]{8, 591}, new int[]{11, 733}, new int[]{1, 517}, new int[]{8, 156}, new int[]{13, 331}, new int[]{11, 889}, new int[]{12, 782}, new int[]{11}, new int[]{2, 578}, new int[]{16, 487}, new int[]{12, 640}, new int[]{14, 112}, new int[]{10, 901}, new int[]{8, 807}, new int[]{7, 818}, new int[]{7, 627}, new int[]{14, 9}, new int[]{4, 522}, new int[]{7, 505}, new int[]{9, 13}, new int[]{3}, new int[]{1, 971}, new int[]{18, 808}, new int[]{1, 17}, new int[]{7, 197}, new int[]{7, 361}, new int[]{2, 986}, new int[]{17, 6}, new int[]{7, 211}, new int[]{15, 342}, new int[]{5, 538}, new int[]{1, 711}, new int[]{11, 863}, new int[]{17, 339}, new int[]{5, 656}, new int[]{4, 402}, new int[]{1, 514}, new int[]{11, 566}, new int[]{12, 11}, new int[]{12}, new int[]{19, 899}, new int[]{19, 526}, new int[]{20, 799}, new int[]{4, 1}, new int[]{17, 363}, new int[]{7, 845}, new int[]{15, 329}, new int[]{17, 369}, new int[]{18, 18}, new int[]{15, 848}, new int[]{5, 928}, new int[]{18, 105}, new int[]{18}, new int[]{17, 785}, new int[]{11, 457}},
                        new int[][]{null, null, null, null, null, null, null, null, null, null, null, new int[]{905}, null, null, null, null, null, null, null, null, new int[]{}, null, null, null, null, null, new int[]{816, 603}, null, null, new int[]{}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new int[]{426, 153, 171, 662, 255, 59, 15}, null, null, new int[]{995, 203, 817}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new int[]{889, 733, 589, 282, 994}, null, null, null, null, null, null, null, null, null, null, null, null, new int[]{773, 394, 476, 667, 812}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new int[]{640, 782, 726, 260}, null, null, null, null, null, null, null, null, null, null, null, null, new int[]{105, 808, 732, 854, 953, 870, 423, 309}, null, null},
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