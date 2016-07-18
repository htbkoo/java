package online.leetcode;

import online.leetcode.util.GuessGame;

/**
 * Created by Hey on 15/Jul/16
 */

/*

https://leetcode.com/problems/guess-number-higher-or-lower/

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Example:

n = 10, I pick 6.

Return 6.

Subscribe to see which companies asked this question

*/


/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
@SuppressWarnings("WeakerAccess")
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int cur = (n + 1) / 2;
        int low = 1;
        int high = n;
        for (int guessResult = guess(cur); (guessResult != 0) && (high - low > 1); guessResult = guess(cur)) {
            if (guessResult == -1) {
                high = cur;
            } else {
                low = cur;
            }
            cur = (int) (((long) high + (long) low) / 2L);
        }
        if (guess(cur) == 0) {
            return cur;
        } else if (guess(low) == 0) {
            return low;
        } else {
            return high;
        }
    }

    public GuessNumberHigherOrLower(int pick) {
        super(pick);
    }
}