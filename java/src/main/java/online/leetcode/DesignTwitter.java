package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Hey on 22/6/16
 */

/*

https://leetcode.com/problems/design-twitter/

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

    postTweet(userId, tweetId): Compose a new tweet.
    getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
    follow(followerId, followeeId): Follower follows a followee.
    unfollow(followerId, followeeId): Follower unfollows a followee.

Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

Subscribe to see which companies asked this question

*/

public class DesignTwitter {

    public static class Twitter {

        private static final int NUM_TWEET = 10;
        private final TwitterDatabase database;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            database = new NaiveTwitterDatabase();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            database.postTweet(userId, tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            return database.getMostRecentTweet(userId, NUM_TWEET);
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followeeId != followerId) {
                database.followDistinct(followerId, followeeId);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId != followerId) {
                database.unfollowDistinct(followerId, followeeId);
            }
        }

        private interface TwitterDatabase {

            void postTweet(int userId, int tweetId);

            List<Integer> getMostRecentTweet(int userId, int numTweet);

            void followDistinct(int followerId, int followeeId);

            void unfollowDistinct(int followerId, int followeeId);
        }

        private class NaiveTwitterDatabase implements TwitterDatabase {
            private final Map<Integer, Set<Integer>> following;
            private final Deque<TweetPair> tweets;

            private class TweetPair {
                private final int UserId;
                private final int TweetId;

                private TweetPair(int userId, int tweetId) {
                    UserId = userId;
                    TweetId = tweetId;
                }

                public int getUserId() {
                    return UserId;
                }

                public int getTweetId() {
                    return TweetId;
                }
            }

            public NaiveTwitterDatabase() {
                following = new HashMap<>();
                tweets = new ArrayDeque<>();
            }

            private boolean hasUser(int userId) {
                return following.containsKey(userId);
            }

            @Override
            public void postTweet(int userId, int tweetId) {
                createUserIfNotExist(userId);
                tweets.push(new TweetPair(userId, tweetId));
            }

            @Override
            public List<Integer> getMostRecentTweet(int userId, int numTweet) {
                createUserIfNotExist(userId);
                final Set<Integer> followees = following.get(userId);
                return tweets.
                        stream().
                        filter(p -> followees.contains(p.getUserId())).
                        limit(10).
                        map(TweetPair::getTweetId).
                        collect(Collectors.toList());
            }

            @Override
            public void followDistinct(int followerId, int followeeId) {
                createUserIfNotExist(followerId);
                following.get(followerId).add(followeeId);
            }

            @Override
            public void unfollowDistinct(int followerId, int followeeId) {
                createUserIfNotExist(followerId);
                following.get(followerId).remove(followeeId);
            }

            private boolean createUserIfNotExist(int userId) {
                if (hasUser(userId)) {
                    return false;
                }
                final HashSet<Integer> followees = new HashSet<>();
                followees.add(userId);
                following.put(userId, followees);
                return true;
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
