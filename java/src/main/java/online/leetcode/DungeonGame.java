package online.leetcode;

/**
 * Created by Hey on 9/10/15
 */

/*

https://leetcode.com/problems/dungeon-game/

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
-2 (K) 	-3 	3
-5 	-10 	1
10 	30 	-5 (P)

Notes:

    The knight's health has no upper bound.
    Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

Credits:
Special thanks to @stellari for adding this problem and creating all test cases.

*/

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        final int firstDimensionLength = dungeon.length;
        final int secondDimensionLength = dungeon[0].length;
        int[][] currentHealth = new int[firstDimensionLength][secondDimensionLength];
        int[][] M = new int[firstDimensionLength][secondDimensionLength];

        currentHealth[firstDimensionLength - 1][secondDimensionLength - 1] = dungeon[firstDimensionLength - 1][secondDimensionLength - 1];
        M[firstDimensionLength - 1][secondDimensionLength - 1] = Math.min(0, dungeon[firstDimensionLength - 1][secondDimensionLength - 1]);

        for (int j = secondDimensionLength - 2; j >= 0; --j) {
            final int cellValue = dungeon[firstDimensionLength - 1][j];
            final int valueRight = M[firstDimensionLength - 1][j + 1] + cellValue;
            M[firstDimensionLength - 1][j] = Math.min(0, valueRight);
            currentHealth[firstDimensionLength - 1][j] = currentHealth[firstDimensionLength - 1][j + 1] + cellValue;
        }

        for (int i = firstDimensionLength - 2; i >= 0; --i) {
            final int cellValue = dungeon[i][secondDimensionLength - 1];
            final int valueDown = M[i + 1][secondDimensionLength - 1] + cellValue;
            M[i][secondDimensionLength - 1] = Math.min(0, valueDown);
            currentHealth[i][secondDimensionLength - 1] = currentHealth[i + 1][secondDimensionLength - 1] + cellValue;
        }

        for (int j = secondDimensionLength - 2; j >= 0; --j) {
            for (int i = firstDimensionLength - 2; i >= 0; --i) {
                final int cellValue = dungeon[i][j];
                final int valueRight = M[i][j + 1] + cellValue;
                final int valueDown = M[i + 1][j] + cellValue;

                if (valueRight > valueDown) { // right is better
                    M[i][j] = Math.min(0, valueRight);
                    currentHealth[i][j] = currentHealth[i][j + 1] + cellValue;
                } else // Down is better
//                    if(valueDown>valueRight)
                {
                    M[i][j] = Math.min(0, valueDown);
                    currentHealth[i][j] = currentHealth[i + 1][j] + cellValue;
                }
//                else{}
                if (cellValue < 0) {
                    M[i][secondDimensionLength - 1] = cellValue;
                } else {
                    M[i][secondDimensionLength - 1] = 0;
                }

            }
        }

        return -M[0][0] + 1;
    }

}
