package online.codewars._5kyu;

import java.util.Arrays;

/**
 * Created by Hey on 21 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/directions-reduction/train/java
 */

/*

Once upon a time, on a way through the old wild west,…

… a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too. Going to one direction and coming back the opposite direction is a needless effort. Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!
How I crossed the desert the smart way.

The directions given to the man are, for example, the following:

String[] plan = { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };

You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:

String[] plan = { "WEST" };

Other examples: In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away. What a waste of time! Better to do nothing. The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure). In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
Task

You have to write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

The Haskell version takes a list of directions with data Direction = North | East | West | South. The Clojure version returns nil when the path is reduced to nothing.
Examples

dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}) => new String[]{"WEST"}
dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}) => new String[]{}

Note

All paths can't be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].

* */

public class DirectionsReduction {
    public static class DirReduction {
        private enum Direction {
            NORTH, SOUTH, WEST, EAST;
            private Direction opposite;

            static {
                NORTH.opposite = SOUTH;
                SOUTH.opposite = NORTH;
                EAST.opposite = WEST;
                WEST.opposite = EAST;
            }

            public boolean isOppositeOf(Direction anotherDirection) {
                return opposite.equals(anotherDirection);
            }
        }

        public static String[] dirReduc(String[] arr) {
            final int length = arr.length;
            String[] stack = new String[length];
            int stackPtr = -1;
            for (String str : arr) {
                if ((stackPtr >= 0) && (stack[stackPtr] != null)) {
                    if (Direction.valueOf(stack[stackPtr]).isOppositeOf(Direction.valueOf(str))) {
                        stack[stackPtr] = str;
                        --stackPtr;
                    } else {
                        ++stackPtr;
                        stack[stackPtr] = str;
                    }
                } else {
                    ++stackPtr;
                    stack[stackPtr] = str;
                }
            }
//            if (stackPtr < 0) {
//                return new String[0];
//            }
            return Arrays.copyOf(stack, stackPtr + 1);
        }

        private static boolean isOpposite(String prev, String cur) {
            return !(prev == null || cur == null) && Direction.valueOf(prev).isOppositeOf(Direction.valueOf(cur));
        }

        private static class Failure {
            public static String[] dirReduc(String[] arr) {
                // Your code here.
                final int length = arr.length;
                int prev = 0;
                for (int i = 1; i < length; ++prev, ++i) {
                    if (isOpposite(arr[prev], arr[i])) {
                        arr[prev] = null;
                        arr[i] = null;
                        --prev;
                    }
                }
                return Arrays.stream(arr).filter(x -> x != null).toArray(String[]::new);
            }
        }
    }

}
