package online.codewars._6kyu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Hey on 16 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/which-are-in/train/java
 */

/*

Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order and without duplicates of the strings of a1 which are substrings of strings of a2.
Example 1:

a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]
Example 2:

a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []
Notes:

Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.

Beware: r must be without duplicates but translators to Haskell and then to Coffeescript and Python introduced duplicates in a1. Don't worry about duplicates in a1 in the other languages.

* */

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(array1));
        Set<String> set2 = Arrays.stream(array2).collect(Collectors.toSet());
        Set<String> resultSet = new TreeSet<>();
        set1.stream()
                .filter(s1 -> !resultSet.contains(s1))
                .filter(s1 -> set2.stream()
                        .anyMatch((s -> s.contains(s1))))
                .forEach(resultSet::add);
        return resultSet.toArray(new String[resultSet.size()]);
    }

    @SuppressWarnings("unused")
    public static class CaseInsensitiveWay {
        public static String[] inArray(String[] array1, String[] array2) {
            Set<String> set1 = new HashSet<>(Arrays.asList(array1));
            Set<String> set2 = Arrays.stream(array2).map(String::toUpperCase).collect(Collectors.toSet());
            Set<String> resultSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            set1.stream()
                    .filter(s1 -> !resultSet.contains(s1))
                    .filter(s1 -> set2.stream()
                            .anyMatch((s -> s.contains(s1.toUpperCase()))))
                    .forEach(resultSet::add);
            return resultSet.toArray(new String[resultSet.size()]);
        }
    }
    /*
    }
    /*
        for (String s1 : set1) {
            if (!resultSet.contains(s1)) {
                if (set2.stream().anyMatch((s -> s.contains(s1.toUpperCase())))) {
                    resultSet.add(s1);
                }
            }
        }
        */
}
