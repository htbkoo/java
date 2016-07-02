package online.codewars._4kyu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hey on 2 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/valid-braces/train/java
 */

/*

Write a function called validBraces that takes a string of braces, and determines if the order of the braces is valid. validBraces should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces four new characters. Open and closed brackets, and open and closed curly braces. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of open parentheses '(' , closed parentheses ')', open brackets '[', closed brackets ']', open curly braces '{' and closed curly braces '}'.

What is considered Valid? A string of braces is considered valid if all braces are matched with the correct brace.
For example:
'(){}[]' and '([{}])' would be considered valid, while '(}', '[(])', and '[({})](]' would be considered invalid.

Examples:
validBraces( "(){}[]" ) => returns true
validBraces( "(}" ) => returns false
validBraces( "[(])" ) => returns false
validBraces( "([{}])" ) => returns true
* */

@SuppressWarnings("WeakerAccess")
public class ValidBraces {
    public static class BraceChecker {
        private enum Brace {
            OP(true), CP(false), OB(true), CB(false), OC(true), CC(false);

            private static final Map<Character, Brace> map = new HashMap<>();
            private final boolean isOpen;
            private Brace pair;

            static {
                map.put('(', OP);
                map.put(')', CP);
                map.put('[', OB);
                map.put(']', CB);
                map.put('{', OC);
                map.put('}', CC);

                OP.pair = CP;
                CP.pair = OP;

                OB.pair = CB;
                CB.pair = OB;

                OC.pair = CC;
                CC.pair = OC;
            }

            Brace(boolean isOpen) {
                this.isOpen = isOpen;
            }

            static Brace of(char c) {
                return map.get(c);
            }

            public boolean isOpen() {
                return isOpen;
            }

            public boolean formPairWith(Brace lastBrace) {
                return pair.equals(lastBrace);
            }
        }

        public boolean isValid(String braces) {
            // Add code here
            final Deque<Brace> stack = new ArrayDeque<>();
            return braces.chars().allMatch(c -> {
                final Brace brace = Brace.of((char) c);
                if (brace.isOpen()) {
                    stack.push(brace);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        final Brace lastBrace = stack.pop();
                        if (!brace.formPairWith(lastBrace)) {
                            return false;
                        }
                    }
                }
                return true;
            }) && stack.isEmpty();
        }
    }
}
