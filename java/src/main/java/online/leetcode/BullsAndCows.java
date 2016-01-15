package online.leetcode;

/**
 * Created by Hey on 14/1/16
 */

/*
https://leetcode.com/problems/bulls-and-cows/

You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"

Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"

In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".

You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

Credits:
Special thanks to @jeantimex for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        final int ARRAY_SIZE = 512;
        int[] secret_occurences = new int[ARRAY_SIZE];
        int[] guess_occurences = new int[ARRAY_SIZE];
        char[] secret_chars = secret.toCharArray();
        char[] guess_chars = guess.toCharArray();
        int A = 0;
        int B = 0;
//        By assumption, You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
        final int length = secret_chars.length;
        for (int i = 0; i < length; ++i) {
            if (secret_chars[i] == guess_chars[i]) {
                ++A;
            } else {
                ++secret_occurences[secret_chars[i]];
                ++guess_occurences[guess_chars[i]];
            }
        }

        for (int i = 0; i < ARRAY_SIZE; ++i) {
            B += Math.min(secret_occurences[i], guess_occurences[i]);
        }

        return String.format("%dA%dB", A, B);
    }
}
