package online.hackerrank.practice.dataStructures.queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class QueueUsingTwoStacks {

    public static class Solution {

        private static final Deque<Integer> stack1 = new ArrayDeque<>();
        private static final Deque<Integer> stack2 = new ArrayDeque<>();

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            try (Scanner sc = new Scanner(System.in)) {

//                final int q = sc.nextInt();
                final int q = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < q; ++i) {
                    final String line = sc.nextLine();
                    sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    final List<Integer> ints = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(toList());

                    handleQuery(ints);
                }
            }
        }

        private static void handleQuery(List<Integer> ints) {
            int queryType = ints.get(0);
            switch (queryType) {
                case 1: {
                    int x = ints.get(1);
                    enqueue(x);
                    return;
                }
                case 2: {
                    dequeue();
                    return;
                }
                case 3: {
                    printPeek();
                }
            }

        }

        private static void enqueue(int x) {
            stack1.push(x);
        }

        private static void dequeue() {
            populateStack2IfNecessary();
            stack2.pop();
        }

        private static void printPeek() {
            populateStack2IfNecessary();
            System.out.println(stack2.peek());
        }

        private static void populateStack2IfNecessary() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
    }


}
