package online.codewars._6kyu;

/**
 * Created by Hey on 19 Jun 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/fibonacci-tribonacci-and-friends/train/java
 */

/*

If you have completed the Tribonacci sequence kata, you would know by now that mister Fibonacci has at least a bigger brother. If not, give it a quick look to get how things work.

Well, time to expand the family a little more: think of a Quadribonacci starting with a signature of 4 elements and each following element is the sum of the 4 previous, a Pentabonacci (well Cinquebonacci would probably sound a bit more italian, but it would also sound really awful) with a signature of 5 elements and each following element is the sum of the 5 previous, and so on.

Well, guess what? You have to build a Xbonacci function that takes a signature of X elements - and remember each next element is the sum of the last X elements - and returns the first n elements of the so seeded sequence.

Xbonacci([1,1,1,1],10)==[1,1,1,1,4,7,13,25,49,94]
Xbonacci([0,0,0,0,1],10)==[0,0,0,0,1,1,2,4,8,16]
Xbonacci([1,0,0,0,0,0,1],10)==[1,0,0,0,0,0,1,1,2,4]

* */

public class FibonacciTribonacciAndFriends {
    public static class Xbonacci {

        public double[] xbonacci(double[] signature, int n) {
            // hackonacci me
            final int signatureLength = signature.length;
            double[] sequence = new double[n];
            System.arraycopy(signature, 0, sequence, 0, Math.min(n, signature.length));
            for (int i = signature.length; i < n; ++i) {
//                In lambda way, but is slower so I avoided doing so.
//                final int curIndex = i;
//                sequence[i] = IntStream.range(0,signature.length).mapToDouble(index->sequence[curIndex-index]).sum();
                for (int j = 1; j <= signatureLength; ++j) {
                    sequence[i] += sequence[i - j];
                }
            }
            return sequence;
        }
    }
}
