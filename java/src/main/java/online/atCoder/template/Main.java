import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        process(testCase);

        output();
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);


        sc.close();
        return new TestCase();
    }

    public static Object process(TestCase testCase) {
        return null;
    }


    private static void output() {
        System.out.println();
    }

    public static class TestCase {

    }
}
