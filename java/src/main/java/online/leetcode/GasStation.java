package online.leetcode;

/**
 * Created by Hey on 27/3/16
 */

/*

https://leetcode.com/problems/gas-station/

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Subscribe to see which companies asked this question

*/

public class GasStation {
//    1ms
    public int canCompleteCircuit(int[] gas, int[] cost) {
        final int length = gas.length;
        if (length <= 0) {
            return -1;
        }

        boolean isPositive = false;
        int positiveStartIndex = -1;
        int positiveRegion = 0;
        int gasInTank = 0;
        for (int i = 0; i < length; ++i) {
            int net = gas[i] - cost[i];
            gasInTank += net;
            positiveRegion += net;
            if (positiveRegion >= 0) {
                if (!isPositive) {
                    isPositive = true;
                    positiveStartIndex = i;
                }
            } else {
                isPositive = false;
                positiveRegion = 0;
                positiveStartIndex = i+1;
            }

        }
        if (gasInTank >= 0) {
            return positiveStartIndex;
        } else {
            return -1;
        }
    }

    @SuppressWarnings({"unused", "UnusedAssignment"})
    private class SecondFailedAttempt {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            final int length = gas.length;
            if (length <= 0) {
                return -1;
            }

            int mostNegativeIndex = 0;
            int max = gas[0] - cost[0];
            int maxIndex = 0;
            int mostNegative = gas[0] - cost[0];
            int gasInTank = 0;
            for (int i = 0; i < length; ++i) {
                int net = gas[i] - cost[i];
                gasInTank += net;
                if (net <= mostNegative) {
                    mostNegative = net;
                    mostNegativeIndex = i;
                }
                if (net > max) {
                    max = net;
                    maxIndex = i;
                }
            }
            if (gasInTank >= 0) {
                if (mostNegativeIndex == length - 1) {
                    return 0;
                }
                return mostNegativeIndex + 1;
            } else {
                return -1;
            }
        }
    }

    @SuppressWarnings({"unused", "UnusedAssignment"})
    private class FirstFailedAttempt {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            final int length = gas.length;
            if (length <= 0) {
                return -1;
            }

            int maxIndex = 0;
            int max = gas[0] - cost[0];
            int gasInTank = 0;
            for (int i = 0; i < length; ++i) {
                int net = gas[i] - cost[i];
                gasInTank += net;
                if (net > max) {
                    max = net;
                    maxIndex = i;
                }
            }
            if (gasInTank >= 0) {
                return maxIndex;
            } else {
                return -1;
            }
        }
    }
}
