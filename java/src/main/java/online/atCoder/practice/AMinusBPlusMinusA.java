package online.atCoder.practice;

public class AMinusBPlusMinusA {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        final int A = sc.nextInt();
        final int B = sc.nextInt();

        final boolean isDivisor = B % A == 0;
        if (isDivisor){
            output(A+B);
        }else{
            output(B-A);
        }
    }

    private static void output(int i) {
        System.out.println(i);
    }
}
