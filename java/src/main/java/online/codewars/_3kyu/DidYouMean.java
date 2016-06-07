package online.codewars._3kyu;

/**
 * Created by Hey on 1 Jun 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

/*

I'm sure, you know Google's "Did you mean ...?", when you entered a search term and mistyped a word. In this kata we want to implement something similar.

You'll get an entered term (lowercase string) and an array of known words (also lowercase strings). Your task is to find out, which word from the dictionary is most similar to the entered one. The similarity is described by the minimum number of letters you have to add, remove or replace in order to get from the entered word to one of the dictionary. The lower the number of required changes, the higher the similarity between each two words.

Same words are obviously the most similar ones. A word that needs one letter to be changed is more similar to another word that needs 2 (or more) letters to be changed. E.g. the mistyped term berr is more similar to beer (1 letter to be replaced) than to barrel (3 letters to be changed in total).

Extend the dictionary in a way, that it is able to return you the most similar word from the list of known words.

Code Examples:

Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

fruits.findMostSimilar("strawbery"); // must return "strawberry"
fruits.findMostSimilar("berry"); // must return "cherry"

Dictionary things = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
things.findMostSimilar("coddwars"); // must return "codewars"

Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
languages.findMostSimilar("heaven"); // must return "java"
languages.findMostSimilar("javascript"); // must return "javascript" (same words are obviously the most similar ones)

I know, many of you would disagree that java is more similar to heaven than all the other ones, but in this kata it is ;)

Additional notes:

    there is always exactly one possible solution

* */

public class DidYouMean {
    public static class Dictionary {

        private final String[] words;

        public Dictionary(String[] words) {
            this.words = words;
        }

        public String findMostSimilar(String to) {
            int min = Integer.MAX_VALUE;
            String mostSimilarString = "";
            for (String word : words) {
                if (word.equals(to)) {
                    return word;
                }
                final int editDistance = getEditDistance(to, word);
                if (editDistance < min) {
                    mostSimilarString = word;
                    min = editDistance;
                }
            }

            // TODO: this is your task ;)
            return mostSimilarString;
        }

        private int getEditDistance(String to, String word) {
            final int toLength = to.length();
            final int wordLength = word.length();
            final int[][] distance = new int[toLength][wordLength];
            for (int i = 0; i < wordLength; ++i) {
                distance[0][i] = i;
            }
            for (int i = 0; i < toLength; ++i) {
                distance[i][0] = i;
            }

            for (int i = 1; i < toLength; ++i) {
                for (int j = 1; j < wordLength; ++j) {
                    distance[i][j] = getMinAmong(distance[i - 1][j], distance[i - 1][j-1], distance[i][j-1]) + ((to.charAt(i) == word.charAt(j)) ? 0 : 1);
                }
            }

            return distance[toLength - 1][wordLength - 1];
        }

        private int getMinAmong(int first, int... nums) {
            int min = first;
            for (int num : nums) {
                min = Math.min(min, num);
            }
            return min;
        }
    }
}
