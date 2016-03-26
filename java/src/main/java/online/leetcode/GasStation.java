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

    private class Prototype {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            final int length = gas.length;
            if (length <= 0) {
                return -1;
            }

            int[] net = new int[length];
            int maxIndex = 0;
            int max = gas[0] - cost[0];
            int gasInTank = 0;
            for (int i = 0; i < length; ++i) {
                net[i] = gas[i] - cost[i];
                gasInTank += net[i];
                if (net[i] > max) {
                    max = net[i];
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
