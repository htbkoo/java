package online.hackerrank.practice.dataStructures.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class MaximumElement {
    public static class Solution {
        private static class QueryHandler {
            private static class ElementAndMax {
                final int element;
                final int max;

                private ElementAndMax(int element, int max) {
                    this.element = element;
                    this.max = max;
                }
            }

            private final List<String> outputs;
            private final Deque<ElementAndMax> stack;

            private QueryHandler() {
                this.outputs = new ArrayList<>();
                this.stack = new ArrayDeque<>();
            }

            List<String> getOutputs() {
                return this.outputs;
            }

            public void process(String line) {
                String[] parts = line.split(" ");
                int queryType = getQueryType(line, parts);
                switch (queryType) {
                    case 1: {
                        push(parts[1]);
                        return;
                    }
                    case 2: {
                        deleteTop();
                        return;
                    }
                    case 3: {
                        addMaxToOutput();
                        return;
                    }
                    default: {
                        throw new IllegalArgumentException("Unknown query type: " + queryType);
                    }

                }
            }

            private int getQueryType(String line, String[] parts) {
                int queryType;
                try {
                    queryType = Integer.parseInt(parts[0]);
                } catch (Exception e) {
                    throw new IllegalArgumentException(String.format("error when parsing query type '%s' in %s ", parts[0], line));
                }
                return queryType;
            }

            private void push(String argument) {
                int element = Integer.parseInt(argument);
                int max = this.stack.isEmpty() ? element : Math.max(element, getMax());
                this.stack.push(new ElementAndMax(element, max));
            }

            private void deleteTop() {
                this.stack.pop();
            }

            private void addMaxToOutput() {
                this.outputs.add(String.valueOf(getMax()));
            }

            private int getMax() {
                if (this.stack.isEmpty()) {
                    throw new IllegalStateException("stack is empty");
                } else {
                    return this.stack.peek().max;
                }
            }
        }

        // Infrastructure
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            try (Scanner sc = new Scanner(System.in)) {

                final int N = sc.nextInt();
//                final int q = Integer.parseInt(sc.nextLine());
                QueryHandler handler = new QueryHandler();

                for (int i = 0; i < N; ++i) {
                    String line = readNextLine(sc);
                    handler.process(line);
                }

                handler.getOutputs().forEach(System.out::println);
            }
        }

        private static String readNextLine(Scanner sc) {
            String line;
            while ((line = sc.nextLine()).length() == 0) {
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            }
            return line;
        }
    }
}
