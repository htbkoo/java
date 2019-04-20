package online.hackerrank.practice.dataStructures.heap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JesseAndCookies {
    public static class Solution {
        private static final int IMPOSSIBLE = -1;

        /*
         * Complete the cookies function below.
         */
        static int cookies(int k, int[] A) {
            /*
             * Write your code here.
             */
            PriorityQueue<Integer> pq = Arrays.stream(A).boxed().collect(Collectors.toCollection(PriorityQueue::new));
            int count = 0;
            do {
                if (pq.size() < 2) {
                    if (pq.isEmpty()) {
                        return count;
                    } else {
                        Integer least = pq.poll();
                        if (least >= k) {
                            return count;
                        } else {
                            return IMPOSSIBLE;
                        }
                    }
                } else {
                    Integer least = pq.poll();
                    if (least >= k) {
                        return count;
                    } else {
                        Integer secondLeast = pq.poll();
                        //noinspection ConstantConditions
                        pq.add(least + 2 * secondLeast);
                        count++;
                    }
                }
            } while (true);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0].trim());

            int k = Integer.parseInt(nk[1].trim());

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");

            for (int AItr = 0; AItr < n; AItr++) {
                int AItem = Integer.parseInt(AItems[AItr].trim());
                A[AItr] = AItem;
            }

            int result = cookies(k, A);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
    }
}
