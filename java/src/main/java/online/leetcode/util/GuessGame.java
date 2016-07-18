package online.leetcode.util;

/**
 * Created by Hey on 15 Jul 2016
 * <p>
 * -----------------------------
 * <p>
 * Util class for 374. Guess Number Higher or Lower
 */
public abstract class GuessGame {
    private final int pick;

    abstract public int guessNumber(int n);

    public GuessGame(int pick) {
        this.pick = pick;
    }

    protected int guess(int num) {
        return Integer.compare(pick, num);
    }
}
