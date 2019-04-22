/*

https://leetcode.com/problems/cherry-pickup/

In a N x N grid representing a field of cherries, each cell is one of three possible integers.



    0 means the cell is empty, so you can pass through;
    1 means the cell contains a cherry, that you can pick up and pass through;
    -1 means the cell contains a thorn that blocks your way.



Your task is to collect maximum number of cherries possible by following the rules below:



    Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
    After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
    When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
    If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.





Example 1:

Input: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
Output: 5
Explanation:
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.



Note:

    grid is an N by N 2D array, with 1 <= N <= 50.
    Each grid[i][j] is an integer in the set {-1, 0, 1}.
    It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.

*/

package online.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CherryPickup {
    class Solution {
        private static final int THORN = -1;
        private static final int CHERRY = 1;
        final State EMPTY_STATE = new State(true, new HashSet<>());
        final State IMPOSSIBLE_STATE = new State(false, new HashSet<>());

        private class Coordinates {
            final int r, c;

            private Coordinates(int r, int c) {
                this.r = r;
                this.c = c;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Coordinates that = (Coordinates) o;
                return r == that.r &&
                        c == that.c;
            }

            @Override
            public int hashCode() {
                return Objects.hash(r, c);
            }
        }

        private class State {
            final boolean isReachable;
            final Set<Coordinates> pickedUpCherries;

            private State(boolean isReachable, Set<Coordinates> pickedUpCherries) {
                this.isReachable = isReachable;
                this.pickedUpCherries = pickedUpCherries;
            }

            State withCherryAt(Coordinates coordinates) {
                if (this.isReachable) {
                    Set<Coordinates> newPickedCherries = new HashSet<>(this.pickedUpCherries);
                    newPickedCherries.add(coordinates);
                    return new State(true, newPickedCherries);
                } else {
                    return IMPOSSIBLE_STATE;
                }
            }

            public int getValue() {
                return pickedUpCherries.size();
            }
        }

        public int cherryPickup(int[][] grid) {
            int N = grid.length;
            State[][][] states = new State[N][N][2];

            states[0][0][0] = isCherry(grid, 0, 0) ? EMPTY_STATE.withCherryAt(new Coordinates(0, 0)) : EMPTY_STATE;
            populateForwardPath(grid, N, states);

            states[N - 1][N - 1][1] = states[N - 1][N - 1][0];
            populateBackwardPath(grid, N, states);

            return states[0][0][1].getValue();
        }

        private void populateForwardPath(int[][] grid, int n, State[][][] states) {
            for (int r = 1; r < n; ++r) {
                populateCell(grid, states, r, 0, r - 1, 0, 0);
            }

            for (int c = 1; c < n; ++c) {
                populateCell(grid, states, 0, c, 0, c - 1, 0);
            }

            for (int r = 1; r < n; ++r) {
                for (int c = 1; c < n; ++c) {
                    if (isBlocked(grid, r, c)) {
                        states[r][c][0] = IMPOSSIBLE_STATE;
                    } else {
                        State betterState = pickBetterState(states[r - 1][c][0], states[r][c - 1][0]);
                        if (isCherry(grid, r, c)) {
                            states[r][c][0] = betterState.withCherryAt(new Coordinates(r, c));
                        } else {
                            states[r][c][0] = betterState;
                        }
                    }
                }
            }
        }

        private void populateBackwardPath(int[][] grid, int n, State[][][] states) {
            for (int r = n - 2; r >= 0; --r) {
                populateCell(grid, states, r, n - 1, r + 1, n - 1, 1);
            }

            for (int c = n - 2; c >= 0; --c) {
                populateCell(grid, states, n - 1, c, n - 1, c + 1, 1);
            }

            for (int r = n - 2; r >= 0; --r) {
                for (int c = n - 2; c >= 0; --c) {
                    if (isBlocked(grid, r, c)) {
                        states[r][c][1] = IMPOSSIBLE_STATE;
                    } else {
                        State betterState = pickBetterState(states[r + 1][c][1], states[r][c + 1][1]);
                        if (isCherry(grid, r, c)) {
                            states[r][c][1] = betterState.withCherryAt(new Coordinates(r, c));
                        } else {
                            states[r][c][1] = betterState;
                        }
                    }
                }
            }


        }

        private void populateCell(int[][] grid, State[][][] states, int r, int c, int rPrev, int cPrev, int phase) {
            if (isBlocked(grid, r, c)) {
                states[r][c][phase] = IMPOSSIBLE_STATE;
            } else if (isCherry(grid, r, c)) {
                states[r][c][phase] = states[rPrev][cPrev][phase].withCherryAt(new Coordinates(r, c));
            } else {
                states[r][c][phase] = states[rPrev][cPrev][phase];
            }
        }

        private boolean isBlocked(int[][] grid, int r, int c) {
            return THORN == grid[r][c];
        }

        private boolean isCherry(int[][] grid, int r, int c) {
            return CHERRY == grid[r][c];
        }

        private State pickBetterState(State state1, State state2) {
            if (!state1.isReachable && !state2.isReachable) {
                return IMPOSSIBLE_STATE;
            } else if (!state1.isReachable) {
                return state2;
            } else if (!state2.isReachable) {
                return state1;
            } else {
                if (state1.getValue() > state2.getValue()) {
                    return state1;
                } else {
                    return state2;
                }
            }
        }
    }
}
