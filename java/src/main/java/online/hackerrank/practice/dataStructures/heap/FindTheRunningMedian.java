package online.hackerrank.practice.dataStructures.heap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {
    public static class Solution {
        /*
         * Complete the runningMedian function below.
         */
        static double[] runningMedian(int[] a) {
            /*
             * Write your code here.
             */
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(Integer::intValue));
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());

            return Arrays.stream(a)
                    .mapToDouble(n -> {
                        append(n, minHeap, maxHeap);
                        return getMedian(minHeap, maxHeap);
                    })
                    .toArray();
        }

        private static void append(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                minHeap.add(n);
            } else {
                double median = getMedian(minHeap, maxHeap);
                if (n > median) {
                    minHeap.add(n);
                } else {
                    maxHeap.add(n);
                }

                if (minHeap.size() - maxHeap.size() >= 2) {
                    maxHeap.add(minHeap.poll());
                } else if (maxHeap.size() - minHeap.size() >= 2) {
                    minHeap.add(maxHeap.poll());
                }
            }
        }

        private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                throw new IllegalStateException("both are empty");
            } else {
                if (minHeap.size() == maxHeap.size()) {
                    return ((double) minHeap.peek() + maxHeap.peek()) / 2d;
                } else {
                    if (maxHeap.size() > minHeap.size()) {
                        return maxHeap.peek();
                    } else {
                        return minHeap.peek();
                    }
                }
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int aCount = Integer.parseInt(scanner.nextLine().trim());

            int[] a = new int[aCount];

            for (int aItr = 0; aItr < aCount; aItr++) {
                int aItem = Integer.parseInt(scanner.nextLine().trim());
                a[aItr] = aItem;
            }

            double[] result = runningMedian(a);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();
        }
    }
}
