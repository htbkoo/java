package online.hackerrank.practice.dataStructures.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

public class EqualStacks {
    public static class Solution {

        private static class Cylinders {
            private final List<Cylinder> cylinders;

            Cylinders(List<Cylinder> cylinders) {
                this.cylinders = cylinders;
            }

            boolean areAllHeightsEqual() {
                return this.cylinders.stream().map(Cylinder::getHeight).collect(toSet()).size() == 1;
            }

            Cylinder getTallestCylinder() {
                return Collections.max(cylinders, Comparator.comparing(Cylinder::getHeight));
            }
        }

        private static class Cylinder {
            private int height;

            private final ArrayDeque<Integer> stack;

            private Cylinder(int height, ArrayDeque<Integer> stack) {
                this.height = height;
                this.stack = stack;
            }

            static Cylinder fromArray(int[] heights) {
                int height = Arrays.stream(heights).sum();
                ArrayDeque<Integer> stack = asStack(heights);
                return new Cylinder(height, stack);
            }

            Integer pop() {
                Integer partHeight = this.stack.pop();
                this.height -= partHeight;
                return partHeight;
            }

            public int getHeight() {
                return height;
            }

            private static ArrayDeque<Integer> asStack(int[] arr) {
                return Arrays.stream(arr).boxed().collect(toCollection(ArrayDeque::new));
            }
        }

        /*
         * Complete the equalStacks function below.
         */
        static int equalStacks(int[] h1, int[] h2, int[] h3) {
            /*
             * Write your code here.
             */
            Cylinder cylinder1 = Cylinder.fromArray(h1);
            Cylinder cylinder2 = Cylinder.fromArray(h2);
            Cylinder cylinder3 = Cylinder.fromArray(h3);
            Cylinders cylinders = new Cylinders(Arrays.asList(cylinder1, cylinder2, cylinder3));

            while (!cylinders.areAllHeightsEqual()) {
                cylinders.getTallestCylinder().pop();
            }

            return cylinders.getTallestCylinder().getHeight();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] n1N2N3 = scanner.nextLine().split(" ");

            int n1 = Integer.parseInt(n1N2N3[0].trim());

            int n2 = Integer.parseInt(n1N2N3[1].trim());

            int n3 = Integer.parseInt(n1N2N3[2].trim());

            int[] h1 = new int[n1];

            String[] h1Items = scanner.nextLine().split(" ");

            for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
                int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
                h1[h1Itr] = h1Item;
            }

            int[] h2 = new int[n2];

            String[] h2Items = scanner.nextLine().split(" ");

            for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
                int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
                h2[h2Itr] = h2Item;
            }

            int[] h3 = new int[n3];

            String[] h3Items = scanner.nextLine().split(" ");

            for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
                int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
                h3[h3Itr] = h3Item;
            }

            int result = equalStacks(h1, h2, h3);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
    }
}
