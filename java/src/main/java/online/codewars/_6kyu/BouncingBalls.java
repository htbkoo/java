package online.codewars._6kyu;

/**
 * Created by Hey on 24 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/bouncing-balls/train/java
 */

/*

A child plays with a ball on the nth floor of a big building the height of which is known

(float parameter "h" in meters, h > 0) .

He lets out the ball. The ball rebounds for example to two-thirds

(float parameter "bounce", 0 < bounce < 1)

of its height.

His mother looks out of a window that is 1.5 meters from the ground

(float parameters window < h).

How many times will the mother see the ball either falling or bouncing in front of the window

(return a positive integer unless conditions are not fulfilled in which case return -1) ?

Note

You will admit that the ball can only be seen if the height of the rebouncing ball is stricty greater than the window parameter.

Example:

    h = 3, bounce = 0.66, window = 1.5, result is 3

    h = 3, bounce = 1, window = 1.5, result is -1

* */

@SuppressWarnings("WeakerAccess")
public class BouncingBalls {
    public static class BouncingBall {

        public static int bouncingBall(double h, double bounce, double window) {
            // your code
//            given h,b,w => find largest n where h*b^n>w
            if (h<0){
                return -1;
            }

            if (h==window){
                return -1;
            }

            if ((bounce<=0)||(bounce>=1)){
                return -1;
            }

            return (window == 0 || h < window) ?
                    0 :
                    (bounce == 1) || (h == 0) ?
                            -1 :
                            2 * (int) (Math.log(window / h) / Math.log(bounce)) + 1;
        }
    }
}