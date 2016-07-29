package online.codewars._4kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Hey on 28 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/strings-mix/train/java
 */

/*

Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.

s1 = "A aaaa bb c"

s2 = "& aaa bbb c d"

s1 has 4 'a', 2 'b', 1 'c'

s2 has 3 'a', 3 'b', 1 'c', 1 'd'

So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.

We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.

The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.

In the result, substrings will be in decreasing order of their length and when they have the same length sorted alphabetically (more precisely sorted by codepoint); the different groups will be separated by '/'.

Hopefully other examples can make this clearer.

s1 = "my&friend&Paul has heavy hats! &"
s2 = "my friend John has many many friends &"
mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

s1="Are the kids at home? aaaaa fffff"
s2="Yes they are here! aaaaa fffff"
mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"

* */

@SuppressWarnings("WeakerAccess")
public class StringsMix {
    public static class Mixing {

        public static String mix(String s1, String s2) {
            // your code
            return new StringMixer(s1, s2).toString();
        }

        private static class StringMixer {
            private final String s1;
            private final String s2;
            private final List<StringMixerItem> items;

            public StringMixer(String s1, String s2) {
                this.s1 = s1;
                this.s2 = s2;
                this.items = computeMix();
            }

            public List<StringMixerItem> computeMix() {
                final Map<Character, String> s1AlternativeStringRepresentation = getAlternativeStringRepresentation(s1);
                final Map<Character, String> s2AlternativeStringRepresentation = getAlternativeStringRepresentation(s2);

                return computeMapDifference(s1AlternativeStringRepresentation, s2AlternativeStringRepresentation);
            }

            private List<StringMixerItem> computeMapDifference(Map<Character, String> sar1, Map<Character, String> sar2) {
                final ArrayList<StringMixerItem> list = new ArrayList<>();

                sar1.keySet().forEach(
                        k -> {
                            final String substring1 = sar1.get(k);
                            if (sar2.containsKey(k)) {
                                list.add(new StringMixerItem(substring1, sar2.get(k)));
                            } else {
                                list.add(new StringMixerItem(substring1, ""));
                            }
                        }
                );

                sar2.keySet().forEach(
                        k -> {
                            if (!sar1.containsKey(k)) {
                                list.add(new StringMixerItem("", sar2.get(k)));
                            }
                        }
                );

                return list;
            }

            private Map<Character, String> getAlternativeStringRepresentation(String str) {
                final Map<Character, String> collect = str.
//                        toLowerCase().
                        chars().
                        filter(c -> c >= 'a' && c <= 'z').
                        mapToObj(i -> (char) i).
                        collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.mapping(Object::toString, Collectors.joining())
                        ));
                return collect.entrySet().
                        stream().
                        filter(e -> e.getValue().length() > 1).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }

            @Override
            public String toString() {
                return items.stream().
                        sorted().
                        map(StringMixerItem::toString).
                        collect(Collectors.joining("/"));
            }

            private static class StringMixerItem implements Comparable<StringMixerItem> {
                private enum Prefix {
                    ONE("1"), TWO("2"), EQUAL("=");

                    private final String prefix;

                    Prefix(String prefix) {
                        this.prefix = prefix;
                    }

                    public String getPrefix() {
                        return prefix;
                    }
                }

                private final Prefix prefix;
                private final String substring;

                public StringMixerItem(String substring1, String substring2) {
                    final int l1 = substring1.length();
                    final int l2 = substring2.length();
                    if (l1 > l2) {
                        prefix = Prefix.ONE;
                        substring = substring1;
                    } else if (l2 > l1) {
                        prefix = Prefix.TWO;
                        substring = substring2;
                    } else {
                        prefix = Prefix.EQUAL;
                        substring = substring1;
                    }
                }

                public int getLength() {
                    return substring.length();
                }

                @Override
                public int compareTo(StringMixerItem o) {
                    final int compareEnum = this.prefix.compareTo(o.prefix);
                    final int compareLength = Integer.compare(this.getLength(), o.getLength());
                    if (compareLength == 0) {
                        if (compareEnum == 0) {
                            return this.substring.compareTo(o.substring);
                        }
                        return compareEnum;
                    }
                    return -compareLength;
                }

                @Override
                public String toString() {
                    return String.format("%s:%s", prefix.getPrefix(), substring);
                }
            }
        }
    }
}
