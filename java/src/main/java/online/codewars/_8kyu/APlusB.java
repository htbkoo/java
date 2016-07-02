package online.codewars._8kyu;

/**
 * Created by Hey on 2 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/a-plus-b/train/java
 * <p>
 * Vasya Pupkin just started learning Java and C#. At first, he decided to write simple program that was supposed to sum up two small numbers (numbers and their sum fit in a byte), but it didn't work. Vasya was too sad to find out what is wrong. Help him to correct the mistake.
 */
@SuppressWarnings("WeakerAccess")
public class APlusB {
    public static class FirstClass {
        public static byte sum(byte a, byte b) {
            //noinspection UnnecessaryLocalVariable, sic from Kata
            byte c = (byte) (a + b);
            return c;
        }
    }
}