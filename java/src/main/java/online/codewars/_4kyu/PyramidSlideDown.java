package online.codewars._4kyu;

/**
 * Created by Hey on 3 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/pyramid-slide-down/train/java
 */

/*

Lyrics...

Pyramids are amazing! Both in architectural and mathematical sense. If you have a computer, you can mess with pyramids even if you are not in Egypt at the time. For example, let's consider the following problem. Imagine that you have a plane pyramid built of numbers, like this one here:

   /3/
  \7\ 4
 2 \4\ 6
8 5 \9\ 3

Here comes the task...

Let's say that the 'slide down' is a sum of consecutive numbers from the top to the bottom of the pyramid. As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23

Your task is to write a function longestSlideDown (in ruby: longest_slide_down) that takes a pyramid representation as argument and returns its' longest 'slide down'. For example,

longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]
// => 23

By the way...

My tests include some extraordinarily high pyramides so as you can guess, brute-force method is a bad idea unless you have a few centuries to waste. You must come up with something more clever than that.

(c) This task is a lyrical version of the Problem 18 and/or Problem 67 on ProjectEuler.

* */

@SuppressWarnings("WeakerAccess")
public class PyramidSlideDown {
    public static class LongestSlideDown {

        public static int longestSlideDown(int[][] pyramid) {
            // Code Goes Here..
            if (pyramid.length <= 0) {
                return 0;
            }

            int[] last = new int[pyramid[0].length];
            for (int[] layer : pyramid) {
                int[] cur = new int[layer.length];
                for (int i = 0; i < layer.length; ++i) {
                    final int curElement = layer[i];
                    if (i == 0) {
                        cur[i] = curElement + last[i];
                    } else if (i == layer.length - 1) {
                        cur[i] = curElement + last[i - 1];
                    } else {
                        cur[i] = curElement + Math.max(last[i], last[i - 1]);
                    }
                }
                last = cur;
            }

            int ans = last[0];
            for (int i : last) {
                ans = Math.max(ans, i);
            }

            return ans;
        }
    }
}
