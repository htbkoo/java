package online.hackerrank.interviewPreparationKit.Arrays

import spock.lang.Specification
import spock.lang.Unroll

class BalancedBracketsTest extends Specification {
    @Unroll
    def "It should print each sorted element"() {
        when:
        String actual = BalancedBrackets.Solution.isBalanced(s)

        then:
        actual == expected

        where:
        s              || expected
        "{[()]}"       || "YES"
        "{[(])}"       || "NO"
        "{{[[(())]]}}" || "YES"
    }

    private static SortingComparator.Player player(String name, int score) {
        new SortingComparator.Player(name, score)
    }
}
