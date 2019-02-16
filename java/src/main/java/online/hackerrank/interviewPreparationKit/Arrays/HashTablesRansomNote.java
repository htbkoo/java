package online.hackerrank.interviewPreparationKit.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote {
    public static class Solution {

        private static final String YES = "Yes";
        private static final String NO = "No";

        // Complete the checkMagazine function below.
        static void checkMagazine(String[] magazine, String[] note) {
            Map<String, Integer> frequencies = new HashMap<>();
            Arrays.stream(magazine)
                    .forEach(word -> {
                        if (frequencies.containsKey(word)) {
                            frequencies.put(word, frequencies.get(word) + 1);
                        } else {
                            frequencies.put(word, 1);
                        }
                    });

            for (String word : note) {
                if (!frequencies.containsKey(word)||frequencies.get(word)==0){
                    output(NO);
                    return;
                }else{
                    frequencies.put(word, frequencies.get(word) - 1);
                }
            }

            output(YES);
        }

        private static void output(String s) {
            System.out.println(s);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            String[] magazine = new String[m];

            String[] magazineItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                String magazineItem = magazineItems[i];
                magazine[i] = magazineItem;
            }

            String[] note = new String[n];

            String[] noteItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                String noteItem = noteItems[i];
                note[i] = noteItem;
            }

            checkMagazine(magazine, note);

            scanner.close();
        }
    }
}
