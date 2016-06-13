package online.codewars._6kyu;

/**
 * Created by Hey on 13 June 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/routes-in-a-square-grid/train/java
 */

/*

Description:

Given a side length n, traveling only right and down how many ways are there to get from the top left corner to the bottom right corner of an n by n grid?

Your mission is to write a program to do just that!

Add code to route(n) that returns the number of routes for a grid n by n (if n is less than 1 return 0).

Examples:

-100 -> 0

1 -> 2

2 -> 6

20 -> 137846528820

Note: you're traveling on the edges of the squares in the grid not the squares themselves.

PS.If anyone has any suggestions of how to improve this kata please let me know.

* */

public class RoutesInASquareGrid {
    public static class RoutesCalc {

        public static long calculateRoutes(int n) {
            //your code goes here
            if (n < 1) {
                return 0;
            }

            long m[][] = new long[n + 1][n + 1];

            for (int i = 0; i <= n; ++i) {
                m[0][i] = 1L;
                m[i][0] = 1L;
            }

            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    m[i][j] = m[i - 1][j] + m[i][j - 1];
                }
            }

            return m[n][n];
        }

    }
}
