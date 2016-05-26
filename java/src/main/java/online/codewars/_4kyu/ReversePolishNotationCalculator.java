package online.codewars._4kyu;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Created by Hey on 25 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/reverse-polish-notation-calculator/train/java
 */

/*

Your job is to create a calculator which evaluates expressions in Reverse Polish notation.

For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3 in normal notation) should evaluate to 14.

Note that for simplicity you may assume that there are always spaces between numbers and operations, e.g. 1 3 + expression is valid, but 1 3+ isn't.

Empty expression should evaluate to 0.

Valid operations are +, -, *, /.

You may assume that there won't be exceptional situations (like stack underflow or division by zero).

* */

public class ReversePolishNotationCalculator {
    public static class Calc {

        public double evaluate(String expr) {
            // TODO: Your awesome code here
            if (expr.isEmpty()) {
                return 0;
            }

            return new ReversePolishNotation(expr).evaluate();
        }

        private static class ReversePolishNotation {
            private final String[] strs;

            public ReversePolishNotation(String expr) {
                strs = expr.split(" ");
            }

            public double evaluate() {
                final Deque<Double> numbersStack = new ArrayDeque<>();
//                final double[] numbersStack = new double[length];
                for (String str : strs) {
                    Unit unit = new Unit(str);
                    final Optional<Operator> optionalOperator = unit.getOptionalOperator();
                    if (optionalOperator.isPresent()) {
                        evaluateWithPrevTwoNumbers(numbersStack, optionalOperator.get());
                    } else {
                        numbersStack.push(unit.getNumber());
                    }
                }

                return numbersStack.pop();
            }

            private void evaluateWithPrevTwoNumbers(Deque<Double> numbersStack, Operator operator) {
                final double prev = numbersStack.pop();
                final double prevPrev = numbersStack.pop();
                numbersStack.push(operator.operate(prevPrev, prev));
            }

            private class Unit {
                private Optional<Operator> operator = Optional.empty();
                private double number = 0d;

                public Unit(String str) {
                    switch (str) {
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            operator = Optional.of(Operator.fromString(str));
                            break;
                        default:
                            number = Double.parseDouble(str);
                    }
                }

                public double getNumber() {
                    return number;
                }

                public Optional<Operator> getOptionalOperator() {
                    return operator;
                }
            }

            private enum Operator {
                PLUS((a, b) -> a + b), MINUS((a, b) -> a - b), MULTIPLIES((a, b) -> a * b), DIVIDES((a, b) -> a / b);

                private final BiFunction<Double, Double, Double> operation;
                private static final Map<String, Operator> mapping = Collections.unmodifiableMap(
                        new HashMap<String, Operator>() {{
                            put("+", PLUS);
                            put("-", MINUS);
                            put("*", MULTIPLIES);
                            put("/", DIVIDES);
                        }}
                );

                Operator(BiFunction<Double, Double, Double> operation) {
                    this.operation = operation;
                }

                public static Operator fromString(String str) {
                    if (!mapping.containsKey(str)) {
                        throw new IllegalArgumentException(String.format("%s is not a valid operator!", str));
                    }
                    return mapping.get(str);
                }

                public double operate(double first, double second) {
                    return operation.apply(first, second);
                }
            }
        }
    }

}
