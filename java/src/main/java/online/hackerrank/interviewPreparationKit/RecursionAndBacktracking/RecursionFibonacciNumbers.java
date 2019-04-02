package online.hackerrank.interviewPreparationKit.RecursionAndBacktracking;

import java.util.Scanner;

public class RecursionFibonacciNumbers {
    public static class Solution {
        public static int fibonacci(int n) {
            // Complete the function.
            if (n < 0) {
                throw new IllegalArgumentException("n should be non-negative, but was: " + n);
            } else if (n == 0) {
                return 0;
//            } else if (n == 1) {
//                return 1;
            } else {
                int minus2 = 0, minus1 = 1;
                while (n > 1) {
                    int temp = minus1;
                    minus1 += minus2;
                    minus2 = temp;
                    n--;
                }
                return minus1;
            }
        }

        public static int fibonacciRecursion(int n) {
            // Complete the function.
            if (n < 0) {
                throw new IllegalArgumentException("n should be non-negative, but was: " + n);
            } else if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
            }
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.close();
            System.out.println(fibonacci(n));
        }
    }
}
