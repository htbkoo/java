package online.atCoder.practice;

import java.util.Scanner;

public class WelcomeToAtCoder {
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            String s = scanner.next();

            System.out.println(String.format("%d %s", a + b + c, s));
        }
    }
}
