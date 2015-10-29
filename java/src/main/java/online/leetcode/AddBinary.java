package online.leetcode;

/**
 * Created by Hey on 29/10/15
 */

/*

https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Subscribe to see which companies asked this question

*/

public class AddBinary {
    public String addBinary(String a, String b) {
        final char[] reverseA = new StringBuilder(a).reverse().toString().toCharArray();
        final char[] reverseB = new StringBuilder(b).reverse().toString().toCharArray();
        StringBuilder result = new StringBuilder();

        final int alength = reverseA.length;
        final int blength = reverseB.length;

        int carry = 0;

        if (alength <= blength) {
            for (int i = 0; i < alength; ++i) {
                int unit = reverseA[i] - 48 + reverseB[i] - 48 + carry;
                carry = 0;
                if (unit >= 2) {
                    carry = 1;
                }
                result.append(String.valueOf(unit % 2));
            }
            for (int i = alength; i < blength; ++i) {
                int unit = reverseB[i] - 48 + carry;
                carry = 0;
                if (unit >= 2) {
                    carry = 1;
                }
                result.append(String.valueOf(unit % 2));
            }
        } else {
            for (int i = 0; i < blength; ++i) {
                int unit = reverseA[i] - 48 + reverseB[i] - 48 + carry;
                carry = 0;
                if (unit >= 2) {
                    carry = 1;
                }
                result.append(String.valueOf(unit % 2));
            }
            for (int i = blength; i < alength; ++i) {
                int unit = reverseA[i] - 48 + carry;
                carry = 0;
                if (unit >= 2) {
                    carry = 1;
                }
                result.append(String.valueOf(unit % 2));
            }
        }

        if (carry == 1) {
            result.append("1");
        }

        if (!result.toString().isEmpty()) {
            return result.reverse().toString();
        } else {
            return "0";
        }
    }

    protected static class WrongAttempt {
        //        Fast to implement, but suffer from overflow
        public String addBinary(String a, String b) {
            return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
        }
    }
}
